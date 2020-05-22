DateTimeFormatter recordedFormatter
            = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSXX");
    DateTimeFormatter displayFormatter
            = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a", Locale.ENGLISH);

    OffsetDateTime dateTime = OffsetDateTime.parse("2019-01-18T07:00:00.000+0530", recordedFormatter);
    String displayDateTime = dateTime.format(displayFormatter);
    System.out.println(displayDateTime);