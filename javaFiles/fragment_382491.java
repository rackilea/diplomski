// get current UTC time - Instant is always in UTC
Instant instant = Instant.now();

// you can use the string representation
System.out.println(instant.toString());// 2017-06-06T11:57:21.665Z
// or the timestamp (epoch millis - milliseconds from 1970-01-01T00:00:00Z)
System.out.println(instant.toEpochMilli());// 1496750241665

// convert to another timezone (always use valid IDs)
ZonedDateTime z = instant.atZone(ZoneId.of("America/Sao_Paulo"));
System.out.println(z);// 2017-06-06T08:57:21.665-03:00[America/Sao_Paulo]

// in another timezone
z = instant.atZone(ZoneId.of("Europe/Berlin"));
System.out.println(z);// 2017-06-06T13:57:21.665+02:00[Europe/Berlin]

// convert back to UTC Instant
System.out.println(z.toInstant()); // 2017-06-06T11:57:21.665Z