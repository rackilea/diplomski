TimeZone.setDefault(null);
System.setProperty("user.timezone", "");
//(above) force fetches and sets the JVM to the timezone the system is set to
LocalDateTime currentDateTime = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), hour, minute, 0);
ZonedDateTime zonedDateTime = currentDateTime.atZone(ZoneId.systemDefault());
date = Date.from(zonedDateTime.toInstant());