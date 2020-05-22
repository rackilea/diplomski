private static final DateTimeFormatter storeFormatter 
        = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
private static final DateTimeFormatter usDisplayFormatter 
        = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
private static final DateTimeFormatter internationalDisplayFormatter 
        = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

private ZoneId userTimeZone = ZoneId.of("America/Rosario");

/** Sets Date to model */
public void setTypedValue(final Object val)
{
    DateTimeFormatter parseFormatter = isUSDateFormatConfig()
            ? usDisplayFormatter : internationalDisplayFormatter;
    final String dateValue = LocalDateTime.parse(val.toString(), parseFormatter)
            .atZone(userTimeZone)
            .withZoneSameInstant(ZoneOffset.UTC)
            .format(storeFormatter);
    model.setValue(dateValue);
    // Other code..
}

/** Retrieves date from model */
public Object getTypedValue()
{
    String dateValue = model.iterator().next().getValue();
    DateTimeFormatter displayFormatter = isUSDateFormatConfig()
            ? usDisplayFormatter : internationalDisplayFormatter;

    final Object result = LocalDateTime.parse(dateValue, storeFormatter)
            .atOffset(ZoneOffset.UTC)
            .atZoneSameInstant(userTimeZone)
            .format(displayFormatter);
    return result;
}