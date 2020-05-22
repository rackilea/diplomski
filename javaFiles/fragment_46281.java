// format date
String dt = "2017-11-14T00:00:00";
// old SimpleDateFormat 
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss", Locale.ENGLISH);
// new SimpleDateFormat 
SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMMM", Locale.ENGLISH);
Date date = null;
    try {
    date = sdf1.parse(dt);
    String newDate = sdf2.format(date);
    System.out.println(newDate);
    Log.e("Date", newDate);
} catch (ParseException e) {
    e.printStackTrace();
}