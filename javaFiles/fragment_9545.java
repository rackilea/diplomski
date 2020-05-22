SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
String inputString1 = "2017-04-01";
String inputString2 = "2018-04-01";

try {
    Date date1 = myFormat.parse(inputString1);
    Date date2 = myFormat.parse(inputString2);
    long diff = date2.getTime() - date1.getTime();
    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
} catch (ParseException e) {
    e.printStackTrace();
}