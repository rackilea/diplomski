String date = "5-12-2015";
DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
Date d = format.parse(date);
DateFormat format1 = new SimpleDateFormat("EEEE, MMM dd");
String finalDateString = format1.format(d);
System.out.println(finalDateString);