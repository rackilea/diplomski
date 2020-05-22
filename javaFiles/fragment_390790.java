// ZoneId accepts the same IDs used by TimeZone
ZoneId zone = ZoneId.of("America/Sao_Paulo");
// convert instant to timezone
ZonedDateTime z = instant.atZone(zone);
System.out.println(z); // 2017-06-03T15:03:55.976-03:00[America/Sao_Paulo]

// converts back to UTC (returns an Instant)
System.out.println(z.toInstant()); // 2017-06-03T18:03:55.976Z