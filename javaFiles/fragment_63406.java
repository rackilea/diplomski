String date1 = "2018-10-12 18:01:01";// yyyy-MM-dd HH:mm:ss
    String date2 = "2018-10-12 18:01";//yyyy-MM-dd HH:mm
    DateTimeFormatter parser = new DateTimeFormatterBuilder()
                    .appendPattern("yyyy-MM-dd HH:mm")
                    .appendOptional(DateTimeFormat.forPattern(":ss").getParser())
                    .toFormatter();
    DateTime dt1 = parser.parseDateTime(date1);
    DateTime dt2 = parser.parseDateTime(date2);
    System.out.println("dt1: " + dt1);
    System.out.println("dt2: " + dt2);