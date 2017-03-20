package ma.integration.batch.convertfactory;

import java.util.Date;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class StringToDateConverterFactory implements ConverterFactory<String, Date> {
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Date> Converter<String, T> getConverter(Class<T> targetType) {
		return (Converter<String,T>)new StringToDateConverter();
	}
}
