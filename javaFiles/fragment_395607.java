String dateString = "2011-5-30 16:13:47";
Date date = new SimpleDateFormat("yyyy-M-dd HH:mm:ss").parse(dateString);
System.out.println(date);
// output: Mon May 30 16:13:47 MST 2011

String dateString2 = "2011-11-3 16:13:47";
Date date2 = new SimpleDateFormat("yyyy-M-dd HH:mm:ss").parse(dateString2);
System.out.println(date2);
// output: Thu Nov 03 16:13:47 MST 2011