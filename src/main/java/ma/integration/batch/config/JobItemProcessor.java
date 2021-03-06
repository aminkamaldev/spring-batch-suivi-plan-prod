package ma.integration.batch.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import ma.integration.batch.convertfactory.StringToDateConverter;
import ma.integration.batch.model.JobCsvReader;
import ma.integration.batch.model.JobExecution;

public class JobItemProcessor implements ItemProcessor<JobCsvReader, JobExecution> {

	@Override
	public JobExecution process(JobCsvReader jobReader) throws Exception {
		GenericConversionService conversionService = new GenericConversionService();
		DefaultConversionService defaultConversionService = new DefaultConversionService();
		/*DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date startTime = null;
		Date endTime = null;*/
		String startTime =" ";
		String endTime =" ";
		conversionService.addConverter(new StringToDateConverter());
		//System.out.println(jobReader.toString());
		String jobName = jobReader.getJobName();
		String oDate = jobReader.getoDate();
		String orderId = jobReader.getOrderId();
		//Date startTime = conversionService.convert(jobReader.getStartTime(), Date.class);
		//Date endTime = conversionService.convert(jobReader.getEndTime(), Date.class);
		//x = x.substring(0, 4) + "." + x.substring(4, x.length());
		if(jobReader.getStartTime().length()>0){
		startTime = jobReader.getStartTime().substring(0, 4)+"/"+jobReader.getStartTime().substring(4, 6)+"/"
							+jobReader.getStartTime().substring(6, 8)+" "+jobReader.getStartTime().substring(8, 10)+":"
							+jobReader.getStartTime().substring(10, 12)+":"+jobReader.getStartTime().substring(12,14);
		}
		if(jobReader.getEndTime().length()>0){
		endTime = jobReader.getEndTime().substring(0, 4)+"/"+jobReader.getEndTime().substring(4, 6)+"/"
				+jobReader.getEndTime().substring(6, 8)+" "+jobReader.getEndTime().substring(8, 10)+":"
				+jobReader.getEndTime().substring(10, 12)+":"+jobReader.getEndTime().substring(12,14);
		}
		String status = jobReader.getStatus();
		String averageRunTime = jobReader.getAverageRunTime();
		Boolean deleted = defaultConversionService.convert(jobReader.getDeleted(), Boolean.class);
		Integer rerunCount = defaultConversionService.convert(jobReader.getRerunCount(), Integer.class);

		JobExecution jobEntity = new JobExecution(jobName, oDate, orderId, startTime, endTime, status, averageRunTime,
				deleted, rerunCount);
		return jobEntity;
	}
}
