// parse date and time
LocalDateTime d = LocalDateTime.parse("2017-07-11T10:53:52");
// convert to UTC
ZonedDateTime z = d.atZone(ZoneOffset.UTC);
// or
OffsetDateTime odt = d.atOffset(ZoneOffset.UTC);
// convert to Instant
Instant instant = z.toInstant();