String val = "Wed Jan 08 08:49:13 GMT+05:30 2014";
    DateFormat inFmt = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
    Date date = inFmt.parse(val);
    DateFormat outFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    outFmt.setTimeZone(TimeZone.getTimeZone("GMT+1:00"));
    System.out.println(outFmt.format(date));