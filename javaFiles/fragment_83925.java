// prefered zones
Set<ZoneId> preferredZones = new HashSet<>();
preferredZones.add(ZoneId.of("Asia/Kolkata"));

DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // date and time
    .appendPattern("MM/dd/yyyy hh:mm a ")
    // zone (use set of prefered zones)
    .appendZoneText(TextStyle.SHORT, preferredZones)
    // use English, because different locales can affect timezones names
    .toFormatter(Locale.ENGLISH);

ZonedDateTime zdt = ZonedDateTime.parse("04/30/2018 06:00 PM IST", fmt);