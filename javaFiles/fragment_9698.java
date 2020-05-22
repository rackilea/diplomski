Instant instant = Instant.parse("2016-03-23T17:14:00.092812Z");
LocalTime newTime = LocalTime.parse("12:34:45.567891");

// or choose another one, the conversion is zone-dependent!!!
ZoneId tzid = ZoneId.systemDefault(); 
Instant newInstant =
    instant.atZone(tzid).toLocalDate().atTime(newTime).atZone(tzid).toInstant();
System.out.println(newInstant); // 2016-03-23T11:34:45.567891Z (in my zone Europe/Berlin)