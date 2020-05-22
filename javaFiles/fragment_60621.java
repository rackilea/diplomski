try {
   SimpleDateFormat format = new SimpleDateFormat("hh:mm a"); //if 24 hour format
   // or
   SimpleDateFormat format = new SimpleDateFormat("HH:mm"); // 12 hour format
   java.util.Date d1 =(java.util.Date)format.parse(your_Time);
   java.sql.Time ppstime = new java.sql.Time(d1.getTime());
} catch(Exception e) {
   Log.e("Exception is ", e.toString());
}