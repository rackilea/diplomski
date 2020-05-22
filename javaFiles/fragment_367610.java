SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(format1.getTimeZone());
    TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
    format1.setTimeZone(utcTimeZone);
    Date date = format1.parse("20-01-2019 13:24:56");
    TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
    format2.setTimeZone(istTimeZone);
    String destDate = format2.format(date);
    System.out.println(destDate); // 2019-01-20 13:24:56