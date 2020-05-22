TimeZone tz = TimeZone.getTimeZone("Europe/Paris")
String timestamp = "29-JAN-2014 01:00:00.000 PM";
DateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS aa");
df.setTimeZone(tz)

try {
    dateFormatted = df.parse(timestamp);
} catch (ParseException execption) {
    execption.printStackTrace();
}