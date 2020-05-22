// No Time Zone
    String from = "2015-06-16T04:35:00.000Z";
    LocalDateTime ldt = LocalDateTime.parse(from, DateTimeFormatter.ISO_ZONED_DATE_TIME);

    // Convert it to UTC
    ZonedDateTime zdtUTC = ZonedDateTime.of(ldt, ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC"));

    // Convert it to IST
    ZonedDateTime zdtITC = zdtUTC.withZoneSameInstant(ZoneId.of("Indian/Cocos"));
    String timestamp = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss").format(zdtITC);
    System.out.println(timestamp);