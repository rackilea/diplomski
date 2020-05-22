ZoneId danishTime = ZoneId.of("Europe/Copenhagen");
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuuMMddHHmmss");
    DateTimeFormatter offsetFormatter = DateTimeFormatter.ofPattern("XX");

    String dateTimeString = "20180730131847";
    String offsetString = "+0200";
    ZoneOffset offset = ZoneOffset.from(offsetFormatter.parse(offsetString));
    ZonedDateTime dateTime = LocalDateTime.parse(dateTimeString, dateTimeFormatter)
            .atOffset(offset)
            .atZoneSameInstant(danishTime);
    System.out.println("Danish time: " + dateTime);