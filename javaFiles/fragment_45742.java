Set<ZoneId> zones = new HashSet<>();
zones.add(ZoneId.of("Europe/Berlin"));
zones.add(ZoneId.of("America/Bogota"));
DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    .appendPattern("EEE MMM dd yyyy HH:mm:ss 'GMT'Z (")
    // optional long timezone name (such as "Colombia Time" or "Pacific Standard Time")
    .optionalStart().appendZoneText(TextStyle.FULL, zones).optionalEnd()
    // optional short timezone name (such as CET or CEST)
    .optionalStart().appendZoneText(TextStyle.SHORT, zones).optionalEnd()
    // close parenthesis
    .appendLiteral(')')
    // use English locale, for month, timezones and day-of-week names
    .toFormatter(Locale.US);