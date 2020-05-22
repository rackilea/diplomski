OffsetDateTime odtSummer = OffsetDateTime.parse(summerTime, OFFSET_FORMAT);
OffsetDateTime odtWinter = OffsetDateTime.parse(winterTime, OFFSET_FORMAT);

Instant instSummer = odtSummer.toInstant();
Instant instWinter = odtWinter.toInstant();

ZonedDateTime zdtSummer = instSummer.atZone(zoneId);
ZonedDateTime zdtWinter = instWinter.atZone(zoneId);

LocalDateTime ldtSummer = zdtSummer.toLocalDateTime();
LocalDateTime ldtWinter = zdtWinter.toLocalDateTime();