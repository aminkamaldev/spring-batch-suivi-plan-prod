package ma.integration.batch.config;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import ma.integration.batch.model.JobCsvReader;
import ma.integration.batch.model.JobExecution;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	@Autowired
	public DataSource dataSource;
	
	@Bean
	public FlatFileItemReader<JobCsvReader>reader(){
		FlatFileItemReader<JobCsvReader> reader = new FlatFileItemReader<JobCsvReader>();
		reader.setResource(new ClassPathResource("Spring_Report_ctm.csv"));
		reader.setLinesToSkip(1);
		reader.setLineMapper(new DefaultLineMapper<JobCsvReader>(){{
			setLineTokenizer(new DelimitedLineTokenizer(){{
				setNames(new String[]{"jobName","oDate","orderId","status","startTime","endTime","averageRuntime","deleted","rerunCount"});
				setDelimiter(";");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<JobCsvReader>(){{
				setTargetType(JobCsvReader.class);
			}});
		}});
		return reader;
	}
	
	@Bean
	public JobItemProcessor jobProcessor(){
		return new JobItemProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<JobExecution> writer(){
		JdbcBatchItemWriter<JobExecution> writer = new JdbcBatchItemWriter<JobExecution>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<JobExecution>());
		writer.setSql("INSERT INTO job_execution (job_id, job_name, o_date, order_id, start_time, end_time, status, average_run_time, deleted, rerun_count) VALUES (:jobId, :jobName, :oDate, :orderId, :startTime, :endTime, :status, :averageRunTime, :deleted, :rerunCount)");
        writer.setDataSource(dataSource);
        return writer;
	}
	
	@Bean
    public Job importUserJob(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importJobExecution")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<JobCsvReader, JobExecution> chunk(10)
                .reader(reader())
                .processor(jobProcessor())
                .writer(writer())
                .build();
    }
	
	
	
	
	
}
