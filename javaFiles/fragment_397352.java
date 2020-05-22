ZoneId zone = ZoneId.of("America/Sao_Paulo");

// October 16th 2016 at midnight, DST started in Sao Paulo
LocalDateTime d = LocalDateTime.of(2016, 10, 16, 0, 0, 0, 0);
ZonedDateTime z = d.atZone(zone);
System.out.println(z);// adjusted to 2017-10-15T01:00-02:00[America/Sao_Paulo]