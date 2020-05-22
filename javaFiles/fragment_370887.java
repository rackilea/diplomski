// always in UTC if not timezone set
Instant.now().minus(1, ChronoUnit.HOURS));
// with timezone, Europe/Berlin for example
Instant.now()
       .atZone(ZoneId.of("Europe/Berlin"))
       .minusHours(1));