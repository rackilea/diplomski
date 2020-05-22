String myDateString = "13:24:40";
    LocalTime localTime = LocalTime.parse(myDateString, DateTimeFormatter.ofPattern("HH:mm:ss"));
    int hour = localTime.get(ChronoField.CLOCK_HOUR_OF_DAY);
    int minute = localTime.get(ChronoField.MINUTE_OF_HOUR);
    int second = localTime.get(ChronoField.SECOND_OF_MINUTE);

    //prints "hour: 13, minute: 24, second: 40":
    System.out.println(String.format("hour: %d, minute: %d, second: %d", hour, minute, second));