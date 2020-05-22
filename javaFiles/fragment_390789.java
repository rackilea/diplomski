// current date/time in UTC - now() always returns the current instant in UTC
Instant instant = Instant.now();
System.out.println(instant); // 2017-06-03T18:03:55.976Z

// equivalent to calendar.getTimeInMillis(), it returns a long
System.out.println(instant.toEpochMilli()); // 1496513035976