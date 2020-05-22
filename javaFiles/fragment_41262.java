String dateStr = "2010-06-14 02:21:49-0400";
SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
TimeZone tz = TimeZone.getDefault();
sdf.setTimeZone(tz);
Date date = sdf.parse(dateStr);

sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
String newDateStr = sdf.format(date);

System.out.println(newDateStr);