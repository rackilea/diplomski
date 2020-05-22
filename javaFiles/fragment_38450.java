ZoneId zid = ZoneId.of("America/New_York");
ZoneOffset offset = ZoneOffset.from(LocalDateTime.now().atZone(zid));
ZonedDateTime zdt0 = ZonedDateTime.of(2014, 8, 24, 21, 10, 1, 777000002, offset);
ZonedDateTime zdt1 = ZonedDateTime.of(2014, 8, 24, 21, 10, 1, 777000002, zid);
System.out.println("isEqual:" + zdt0.isEqual(zdt1));
System.out.println("equals: " + zdt0.equals(zdt1));