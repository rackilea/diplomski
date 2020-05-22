public ZonedDateTime parseToZonedDateTime(String date, String dateFormat) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

    // try to create a ZonedDateTime, if it fails, try LocalDateTime
    TemporalAccessor parsed = formatter.parseBest(date, ZonedDateTime::from, LocalDateTime::from);

    // if it's a ZonedDateTime, return it
    if (parsed instanceof ZonedDateTime) {
        return (ZonedDateTime) parsed;
    }
    if (parsed instanceof LocalDateTime) {
        // convert LocalDateTime to JVM default timezone
        LocalDateTime dt = (LocalDateTime) parsed;
        return dt.atZone(ZoneId.systemDefault());
    }

    // if it can't be parsed, return null or throw exception?
    return null;
}