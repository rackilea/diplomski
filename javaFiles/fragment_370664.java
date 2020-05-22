DateFormat oDateFormat = new SimpleDateFormat("dd/MMMMM/yyyy:HH:mm:ss.SSS");
String sDate = "29/May/2013:09:12:06.80625";
long lMicroseconds;

// Computing milliseconds from microseconds since it the number of digits can change
lMicroseconds = Long.valueOf(sDate.substring(sDate.indexOf('.') + 1,sDate.length()));
sDate = sDate.substring(0,sDate.indexOf('.')) + "." + (lMicroseconds / 1000);

System.out.println(oDateFormat.parse(sDate));