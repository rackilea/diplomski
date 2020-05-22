DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            .appendPattern("[X]")
            .parseDefaulting(ChronoField.OFFSET_SECONDS, 0)
            .toFormatter();

    String withoutZ = "2018-07-21T00:50:39";
    Instant anInstant = formatter.parse(withoutZ, Instant::from);
    System.out.println(anInstant);

    String withZ = "2017-11-20T23:18:27.529Z";
    Instant anotherInstant = formatter.parse(withZ, Instant::from);
    System.out.println(anotherInstant);