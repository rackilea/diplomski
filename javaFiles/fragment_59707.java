ZoneId zone = ZoneId.of("America/Sao_Paulo");

// October 15th 2017 at midnight, DST starts in Sao Paulo
LocalDateTime d = LocalDateTime.of(2017, 10, 15, 0, 0, 0, 0);
ZonedDateTime z = d.atZone(zone);
System.out.println(z);// adjusted to 2017-10-15T01:00-02:00[America/Sao_Paulo]