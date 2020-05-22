ZoneId timezone = ZoneId.of("Brazil/East");

ZonedDateTime t = ZonedDateTime.of(2018, 10, 20, 7, 52, 16, 0, timezone);

System.out.println(t);
System.out.println(t.plus(1, ChronoUnit.DAYS));
System.out.println(t.plus(24, ChronoUnit.HOURS));