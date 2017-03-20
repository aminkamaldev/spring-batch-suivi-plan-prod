package ma.integration.batch.convertfactory;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String,Date> {
	Date date = new Date();
	@Override
	public Date convert(String source) {
		if(source == null || source ==""){
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Date.class), source, null);
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			date = formatter.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
