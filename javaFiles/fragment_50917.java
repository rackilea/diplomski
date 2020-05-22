String dateString = "19801115";
String timeString = "1530";

Date date = null;
try {
    date = new SimpleDateFormat("yyyyMMddhhmm").parse(dateString + timeString);
} catch (ParseException e) {
    e.printStackTrace();
}
Instant reqInstant = date.toInstant();
System.out.println(reqInstant); // time here depends on your local settings, may differ from 15:30

// this way you adjust an Instant to a time zone you need
ZonedDateTime zdt = ZonedDateTime.ofInstant(reqInstant, ZoneId.systemDefault() /*<- needed time zone here*/);
System.out.println(zdt.toInstant()/*returns an Instant*/);