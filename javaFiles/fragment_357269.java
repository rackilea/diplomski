SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
String dateString = "2017-01-30T19:00:00+0000";
try {

    Date date = formatter.parse(dateString);
    System.out.println(date);

} catch (ParseException e) {
    //throw exception
}