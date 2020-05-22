private static final DateTimeFormatter format = new DateTimeFormatterBuilder().appendPattern("dd-MM-uuuu")
        .optionalStart()
        .appendPattern(" HH:mm:ss")
        .optionalEnd()
        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
        .toFormatter();

public ZonedDateTime getZdt(String myDate) {
    return LocalDateTime.parse(myDate, format).atZone(ZoneId.systemDefault());
}