String date = "02:13:2013:14:45:42"; // one of these is your end time
String date2 = "02:13:2013:14:45:49"; // the other gets smaller every time as you approach the end time
// 7 seconds difference

DateTimeFormatter format = DateTimeFormat.forPattern("MM:dd:yyyy:HH:mm:ss"); // your pattern

DateTime dateTime = format.parseDateTime(date);
System.out.println(dateTime);

DateTime dateTime2 = format.parseDateTime(date2);
System.out.println(dateTime2);

Duration duration = new Duration(dateTime, dateTime2);
System.out.println(duration.getMillis());