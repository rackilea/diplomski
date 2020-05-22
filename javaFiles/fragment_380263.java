SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
Date c = sdf.parse("2017-03-31T10:38:14.472Z");

System.out.println(c);

DateFormat istFormat = new SimpleDateFormat();
DateFormat gmtFormat = new SimpleDateFormat();
TimeZone gmtTime = TimeZone.getTimeZone("GMT");
TimeZone istTime = TimeZone.getTimeZone("IST");

istFormat.setTimeZone(gmtTime);
gmtFormat.setTimeZone(istTime);
System.out.println("GMT Time: " + istFormat.format(c));
System.out.println("IST Time: " + gmtFormat.format(c));