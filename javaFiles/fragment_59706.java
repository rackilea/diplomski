String timeDateStr = "2017-18-08 12:60:30.345";
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss.SSS")
    // use lenient parsing
    .withResolverStyle(ResolverStyle.LENIENT);
// parse to LocalDateTime
LocalDateTime dt = LocalDateTime.parse(timeDateStr, dtf);