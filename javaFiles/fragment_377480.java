String utcTime = "2016-06-17 14:22:02Z";
DateTimeFormatter parser = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ssZ");
DateTime dateTime = parser.parseDateTime(utcTime).withZone(DateTimeZone.forID("Asia/Kolkata"));
DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-YYYY HH:mm:ss");
System.out.println(dateTime);
LocalDateTime localDateTime = dateTime.toLocalDateTime();
String formattedlocalDateTime = formatter.print(localDateTime);
System.out.println(formattedlocalDateTime);