String hours = "05";
    String minutes = "45";
    String ampm = "PM";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd hh:mm a");
    LocalDateTime dateTime = LocalDateTime.parse(String.format("20160101 %s:%s %s", hours, minutes, ampm), formatter);

    System.out.println(dateTime);