String source = "06-12-2015 02:10:10 PM";
String pattern = "MM-dd-yyyy hh:mm:ss a";
DateFormat sdf = new SimpleDateFormat(pattern);
try {
    Date date = sdf.parse(source);
    ZonedDateTime zdt = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC"));
    System.out.println(zdt.format(DateTimeFormatter.ofPattern(pattern)));
} catch (ParseException e) {
    e.printStackTrace();
}