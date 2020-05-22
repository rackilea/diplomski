String dtc = "2014-04-02T07:59:02.111Z";
SimpleDateFormat readDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
readDate.setTimeZone(TimeZone.getTimeZone("GMT")); // missing line
Date date = readDate.parse(dtc);
SimpleDateFormat writeDate = new SimpleDateFormat("dd.MM.yyyy, HH.mm");
writeDate.setTimeZone(TimeZone.getTimeZone("GMT+04:00"));
String s = writeDate.format(date);