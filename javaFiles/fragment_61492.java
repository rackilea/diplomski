private static final DateTimeFormatter DATETIME_PARSER =
    DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss 'UTC' yyyy")
        .withLocale(Locale.US)
        .withZoneUTC();

...

DateTime dateTime = DATETIME_PARSER.parseDateTime(text);