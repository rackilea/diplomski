public ZonedDateTime parseToZonedDateTime(String date, String dateFormat) {
    // use java.time from java 8
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
    ZonedDateTime zonedDateTime = null;
    try {
        zonedDateTime = ZonedDateTime.parse(date, formatter);
    } catch (DateTimeException e) {
        // couldn't parse to a ZoneDateTime, try LocalDateTime
        LocalDateTime dt = LocalDateTime.parse(date, formatter);

        // convert to a timezone
        zonedDateTime = dt.atZone(ZoneId.systemDefault());
    }
    return zonedDateTime;
}