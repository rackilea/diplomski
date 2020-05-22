String zoneName = "America/Los_Angeles";
DateTimeFormatter outputDtf = DateTimeFormatter
        .ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")
        .withZone(ZoneId.of(zoneName));

// timestamp in UTC. convert to zone America/Los_Angeles
DateTimeFormatter timestampDtf = DateTimeFormatter
        .ofPattern("yyyyMMddHHmmss")
        .withZone(ZoneOffset.UTC);
String timestamp = "20180722060602";
ZonedDateTime zdt1 = ZonedDateTime.parse(timestamp, timestampDtf);
System.out.println(outputDtf.format(zdt1)); // 2018-07-21T23:06:02-0700

// date in zone America/Los_Angeles. add start of day and zone
DateTimeFormatter dateDtf = new DateTimeFormatterBuilder()
        .appendPattern("yyyy-MM-dd")
        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
        .toFormatter()
        .withZone(ZoneId.of(zoneName));
String date = "2018-07-18";
ZonedDateTime zdt2 = ZonedDateTime.parse(date, dateDtf);
System.out.println(outputDtf.format(zdt2)); // 2018-07-18T00:00:00-0700