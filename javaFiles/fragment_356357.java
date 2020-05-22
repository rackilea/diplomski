public static DateTime datetime(String timeStamp, String timeZone) {
    return TIMESTAMP_FORMAT.withZone(DateTimeZone.forID(timeZone))
            .withLocale(Locale.ENGLISH)
            .parseDateTime(timeStamp)
            .withZone(DateTimeZone.UTC);
}