String timeStamp = "20180623 05:58:15";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss", Locale.ENGLISH);
    LocalDateTime ldt = LocalDateTime.parse(timeStamp, formatter);
    ldt = ldt.minusMinutes(2);
    System.out.println(ldt);
    System.out.println(ldt.format(formatter));