//Assign utc calendar
Calendar utc= Calendar.getInstance();
utc.setTimeZone(TimeZone.getTimeZone("UTC"));
Timestamp timestamp = rs.getTimestamp("timestampcolumn", utc);
//Convert to client date time
DateTime dateTime = new DateTime(timestamp.getTime(), DateTimeZone.forID("Asia/Kolkata"));
//Format
DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-YYYY HH:mm:ss");
//Change to client wall clock time
LocalDateTime localDateTime = dateTime.toLocalDateTime();
String formattedlocalDateTime = formatter.print(localDateTime)