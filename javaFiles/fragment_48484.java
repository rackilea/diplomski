public ZonedDateTime getZonedDateTime(String time) {
    long longTime = Long.parseLong(time), yearOffset = 3000L;
    String timeZone = "US/Pacific";
    ZoneId zoneId = ZoneId.of(timeZone);
    ZonedDateTime zdt = Instant.ofEpochSecond(longTime).atZone(zoneId);
    if (zdt.getLong(ChronoField.YEAR_OF_ERA) >= yearOffset) {
        return Instant.ofEpochMilli(longTime).atZone(zoneId);
    } else {
        return zdt;
    }
}