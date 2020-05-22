//Getting the LocalDateTime Objects from String values
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm"); 
    String txtStartTime = "2017-03-29 12:00";

    LocalDateTime ldtStart = LocalDateTime.parse(txtStartTime, df);


    //Convert to a ZonedDate Time in UTC
    ZoneId zid = ZoneId.systemDefault();

    ZonedDateTime zdtStart = ldtStart.atZone(zid);
    System.out.println("Local Time: " + zdtStart);
    ZonedDateTime utcStart = zdtStart.withZoneSameInstant(ZoneId.of("UTC"));
    System.out.println("Zoned time: " + utcStart);
    ldtStart = utcStart.toLocalDateTime();
    System.out.println("Zoned time with zone stripped:" + ldtStart);
    //Create Timestamp values from Instants to update database
    Timestamp startsqlts = Timestamp.valueOf(ldtStart); //this value can be inserted into database
    System.out.println("Timestamp to be inserted: " +startsqlts);

    //insertDB(startsqlts);