DateTime[] timestamp = new DateTime[10];

for(int i=0; i<10; i++){
   //set the start of the period
   DateTime time = new DateTime(2014, 12, 27, 18, 30, 50);
   //add i days to the start date
   timestamp[i] = time.plus(Period.days(i));

   int weekYear = timestamp[i].getWeekyear();
   int weekOfWeekyear = timestamp[i].getWeekOfWeekyear();

   Log.d(Constants.LOG_TAG, timestamp[i].toString("EEEE, MMMM d, yyyy") + " | year.week = " + weekYear + "." + weekOfWeekyear);
}