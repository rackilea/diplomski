ZoneId zoneId = ZoneId.of("America/New_York");
ZonedDateTime dateAndTimeForAccount = ZonedDateTime.ofInstant(now, zoneId);
System.out.println(dateAndTimeForAccount);

ValueRange hourRange = ValueRange.of(8, 10);
System.out.printf("is hour (%s) in range [%s] -> %s%n", 
        dateAndTimeForAccount.getHour(),
        hourRange, 
        hourRange.isValidValue(dateAndTimeForAccount.getHour())
);