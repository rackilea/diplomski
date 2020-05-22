DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .append(DateTimeFormatter.ISO_LOCAL_DATE)
    .appendLiteral(' ')
    .append(DateTimeFormatter.ISO_LOCAL_TIME)
    .toFormatter();

LocalDateTime oldTime = LocalDateTime.parse("2018-03-21 00:00:00.0", formatter);
LocalDateTime newTime = oldTime.withHour(23).withMinute(18).withSecond(19).withNano(0);

System.out.println(newTime.format(formatter));