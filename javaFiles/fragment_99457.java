String input1 = "Sat Sep 10 07:30:20 IDT 2016";
String input2 = "Sat Dec 10 07:30:20 IST 2016";
SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
Date d1 = sdf.parse(input1);
Date d2 = sdf.parse(input2);

SimpleDateFormat sdfOut =
    new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
sdfOut.setTimeZone(TimeZone.getTimeZone("UTC"));
System.out.println("IDT=>UTC: " + sdfOut.format(d1));
System.out.println("IST=>UTC: " + sdfOut.format(d2));