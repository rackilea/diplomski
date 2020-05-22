DateTimeFormatter formatterWithoutColon 
            = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ssxx");
    String createdAtString = "2017-04-23T19:47:39+00:00";
    OffsetDateTime dateTime = OffsetDateTime.parse(createdAtString);
    String inDesiredFormat = dateTime.format(formatterWithoutColon);
    System.out.println(inDesiredFormat);