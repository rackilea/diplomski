// parser (format with 6 digits in fraction of second)
DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX");
// parse input, use UTC+8 (ZoneOffset.ofHours(8))
ZonedDateTime dt = ZonedDateTime.parse("2016-06-26T16:32:31.654120+00:00", parser)
    .withZoneSameInstant(ZoneOffset.ofHours(8));

// formatter for output, using your format
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
System.out.println(formatter.format(dt)); // 2016-06-27 00:32:31.654120