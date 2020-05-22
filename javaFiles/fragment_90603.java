//Let's create our zone time (just to keep your logic
LocalDateTime ldt = LocalDateTime.now();
ZonedDateTime zonedDateTime =ldt.atZone(ZoneId.of("Asia/Kolkata"));

//Then get the epoch on GMT
long e = zonedDateTime.toInstant().toEpochMilli();

Instant i = Instant.ofEpochMilli(e);
System.out.println(ZonedDateTime.ofInstant(i, ZoneId.systemDefault()));
System.out.println(ZonedDateTime.ofInstant(i, ZoneId.of("Asia/Kolkata")));