OffsetDateTime odtSummer = OffsetDateTime.parse(summerTime, OFFSET_FORMAT);
OffsetDateTime odtWinter = OffsetDateTime.parse(winterTime, OFFSET_FORMAT);

ZonedDateTime zdtSummer = odtSummer.atZoneSameInstant(zoneId);
ZonedDateTime zdtWinter = odtWinter.atZoneSameInstant(zoneId);

LocalDateTime ldtSummer = zdtSummer.toLocalDateTime();
LocalDateTime ldtWinter = zdtWinter.toLocalDateTime();