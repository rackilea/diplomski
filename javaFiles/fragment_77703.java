LocalDateTime now = LocalDateTime.now();                  //Get current Date time
LocalDateTime nextSaturday = now                          //Get date time
        .with(TemporalAdjusters.next(DayOfWeek.SATURDAY)) //of next SATURDAY
        .with(LocalTime.of(20, 0));                       //at 20:00   

//Now you can use until with ChronoUnit.MILLIS to get millisecond betwenn the two dates
long millSeconds = now.until(nextSaturday, ChronoUnit.MILLIS);
//or             = ChronoUnit.MILLIS.between(now, nextSaturday);

System.out.println(now);          //2018-07-05T16:54:54.585789200
System.out.println(nextSaturday); //2018-07-07T20:00
System.out.println(millSeconds);  //183905414