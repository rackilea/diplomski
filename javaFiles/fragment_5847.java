private static DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
        .append(DateTimeFormatter.ISO_LOCAL_DATE)
        .appendLiteral(' ')
        .append(DateTimeFormatter.ISO_LOCAL_TIME)
        .toFormatter();

public static long stringToMilliseconds(String string) {
    return LocalDateTime.parse(string, FORMATTER)
            .toInstant(ZoneOffset.UTC)
            .toEpochMilli();
}