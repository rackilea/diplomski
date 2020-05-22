// when parsing, if finds ambiguous CET or CEST, it uses Berlin as prefered timezone
Set<ZoneId> set = new HashSet<>();
set.add(ZoneId.of("Europe/Berlin"));

DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // your pattern (weekday, month, day, hour/minute/second)
    .appendPattern("EE MMM dd HH:mm:ss ")
    // optional timezone short name (like "CST" or "CEST")
    .optionalStart().appendZoneText(TextStyle.SHORT, set).optionalEnd()
    // optional GMT offset (like "GMT+02:00")
    .optionalStart().appendPattern("OOOO").optionalEnd()
    // year
    .appendPattern(" yyyy")
    // create formatter (using English locale to make sure it parses weekday and month names correctly)
    .toFormatter(Locale.US);