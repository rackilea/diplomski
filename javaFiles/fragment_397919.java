SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
 try {
       Date myDate = inFormat.parse(date+"-"+month+"-"+year);
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
       String dayName=simpleDateFormat.format(myDate);
 } catch (ParseException e) {
     e.printStackTrace();
}