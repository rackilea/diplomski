long strt = System.currentTimeMillis();// 1462968291733
    Thread.sleep(5000);
    long end = System.currentTimeMillis();// 1462968296733

    long diff = end - strt;


    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(diff);
    TimeZone cutsomTimeZone = TimeZone.getTimeZone("IST");

     DateFormat formatter = new SimpleDateFormat
                ("EEE MMM dd HH:mm:ss zzz yyyy");
    formatter.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
    System.out.println(formatter.format(calendar.getTime()));//

    formatter.setTimeZone(cutsomTimeZone);
    System.out.println(formatter.format(calendar.getTime()));