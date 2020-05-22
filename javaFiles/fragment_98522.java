package ch.hedgesphere.core.blazeds.translator;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import flex.messaging.io.amf.translator.ASTranslator;


public class HedgesphereASTranslator extends ASTranslator {

@SuppressWarnings({"rawtypes"})
@Override
public Object convert(Object originalValue, Class type) {
    if( type.equals(DateTime.class)) {
        return convertToDateTime(originalValue);
    }
    if( type.equals(LocalDate.class)) {
    return convertToLocalDate(originalValue); 
    }
    if( type.equals(LocalTime.class)) {
        return convertToLocalTime(originalValue);
    }

    return super.convert(originalValue, type);
}

private Object convertToLocalTime(Object originalValue) {
    return originalValue == null ? null : new LocalTime(originalValue);
}

private Object convertToLocalDate(Object originalValue) {
    return originalValue == null ? null : new LocalDate(originalValue); 
}

private Object convertToDateTime(Object originalValue) {
    return originalValue == null ? null : new DateTime(originalValue);
}

@SuppressWarnings({"rawtypes"})
@Override
public Object createInstance(Object source, Class type) {
    return super.createInstance(source, type);
}
}