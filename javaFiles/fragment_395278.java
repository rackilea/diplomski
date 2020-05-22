String dtStr1 = "06 June 01:54 PM"; 
    DateTimeFormatter formatter1 = new DateTimeFormatterBuilder()
            .appendPattern("dd MMMM hh:mm a")
            .parseDefaulting(ChronoField.YEAR, 2019)
            .toFormatter();
    LocalDateTime date1 = LocalDateTime.parse(dtStr1, formatter1);

    String dtStr2 = "Thursday 30 May 2019 - 02:00 PM";  
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEEE dd MMM uuuu - hh:mm a");
    LocalDateTime date2 = LocalDateTime.parse(dtStr2, formatter2);

    System.out.println(date1);
    System.out.println(date2);