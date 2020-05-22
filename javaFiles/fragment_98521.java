package ch.hedgesphere.core.blazeds.serialization;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import flex.messaging.io.SerializationContext;

public class AMF3Output extends flex.messaging.io.amf.Amf3Output {

public AMF3Output(SerializationContext context) {
    super(context);
}

@Override
public void writeObject(Object value) throws IOException {
    if(value instanceof DateTime) {
        value = convertToDate((DateTime)value);
    }
    if(value instanceof LocalDate) {
        value = convertToDate((LocalDate)value);
    }
    if(value instanceof LocalTime) {
    value = convertToDate((LocalTime)value);
    }
    super.writeObject(value);
}

private Object convertToDate(LocalTime time) {
    return time.toDateTimeToday().toDate();
}

private Object convertToDate(LocalDate date) {
    return date.toDateMidnight().toDate();
}

private Object convertToDate(DateTime dateTime) {
    return dateTime.toDate();
}   
}