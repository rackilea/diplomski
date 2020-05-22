public static void main(String[] args) {

   // create a calendar
   Calendar cal = Calendar.getInstance();

   // get the time in milliseconds
   System.out.println("Current time is :" + cal.getTime());

   // set time to 5000 ms after january 1 1970
   cal.setTimeInMillis(5000);

   // print the new time
   System.out.println("After setting Time:  " + cal.getTime());
   }