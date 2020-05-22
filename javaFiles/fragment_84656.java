public static Object getFormattedValue(Object value) {
    String updated = (strValue).replaceAll(pattern, "$1"); //$NON-NLS-1$
    long millis = Long.parseLong(updated);
    return getFormat().format(new Date(millis));
}

public static Object getOdataValue(Object value) throws ParseException {
    DateFormat dateFormat = getFormat();
    Date parsedDate = dateFormat.parse(value.toString());
    return "\"/Date(" + date.getTime() + ")/\""; //$NON-NLS-1$ //$NON-NLS-2$
}