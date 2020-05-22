String ts = "05-Aug-15 11:30 PM BST";
DateFormat df1 = new SimpleDateFormat("dd-MMM-yy hh:mm aa z");
DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
df2.setTimeZone(TimeZone.getTimeZone("UTC"));
Date myDate = df1.parse(ts);
System.out.println(df1.format(myDate)); // <-- this is how I saw it
String myd = df2.format(myDate);
System.out.println(myd);