String strDate = "2016-08-19 12:04:56.993";
SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
Date date = isoFormat.parse(strDate);
System.out.println(date);
System.out.println(date.getTime());