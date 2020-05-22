String dateTimeString = "01/14/2016 07:37:36PM"; 
    String offsetString = "-08:00";

    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString,
            DateTimeFormatter.ofPattern("MM/dd/uuuu hh:mm:ssa"));
    ZoneOffset offset = ZoneOffset.of(offsetString);
    String formattedTimestamp = dateTime.atOffset(offset).toString();
    System.out.println(formattedTimestamp);