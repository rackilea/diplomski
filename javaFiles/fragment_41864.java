DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ssz");

ZonedDateTime zdtEastern = ZonedDateTime.now(ZoneId.of("America/New_York"));
ZonedDateTime zdtMinus4 = ZonedDateTime.now(ZoneId.of("GMT-04:00"));

System.out.println(zdtEastern.format(fmt)); // Prints: 14-08-2019_19:40:36EDT
System.out.println(zdtMinus4.format(fmt));  // Prints: 14-08-2019_19:40:36GMT-04:00