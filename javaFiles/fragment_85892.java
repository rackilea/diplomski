int day = datePicker.getDayOfMonth();
int year = datePicker.getYear();
int month = datePicker.getMonth() + 1;

try {
     SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
     Date date = sdf.parse(day + "-" + month + "-" + year);

     sdf = new SimpleDateFormat("EEE MMM dd yyyy");
     String strDate = sdf.format(date) + " 00:00:00 GMT+0530 (IST)";

     Log.d("date_simple", strDate);

} catch (ParseException e) {
     Log.d("date_simple", e + "");
     e.printStackTrace();
}