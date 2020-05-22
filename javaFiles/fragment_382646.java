DateTimeFormatter formatter = ISODateTimeFormat.dateTimeNoMillis();
LocalDateTime ldt = new LocalDateTime();
String val = ldt.toString(formatter);
System.out.println(val);    
val += "Z";
LocalDateTime nldt = LocalDateTime.parse(val, formatter);
System.out.println(nldt.toString());