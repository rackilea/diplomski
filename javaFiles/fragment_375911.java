DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .appendPattern("dd/MM/yyyy a")
    .parseDefaulting(ChronoField.HOUR_OF_AMPM, 0) // this is required
    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0) // optional, but you can set other value
    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0) // optional as well
    .toFormatter();
System.out.println(LocalDateTime.parse("17/02/2015 PM", formatter)); // 2015-02-17T12:00
System.out.println(LocalDateTime.parse("17/02/2015 AM", formatter)); // 2015-02-17T00:00