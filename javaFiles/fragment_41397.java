package util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;

/**
 * Created by aratan on 2/25/2015.
 */
@Converter
public class MyConverter implements AttributeConverter<String, Time> {
    @Override
    public Time convertToDatabaseColumn(String s) {
        System.out.println("::::=========================convertToEntityAttribute ::" + s);
        return new Time(System.currentTimeMillis());
    }

    @Override
    public String convertToEntityAttribute(Time time) {
        System.out.println("::::=========== convertToDatabaseColumn  ====== DateUtil.getFormattedTime(time) ::" + DateUtil.getFormattedTime(time));
        return DateUtil.getFormattedTime(time);
    }
}