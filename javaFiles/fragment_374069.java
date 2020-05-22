Timer timer  new Timer();
Thread myThread= // Your thread
Calendar date = Calendar.getInstance();
date.set(
  Calendar.DAY_OF_WEEK,
  Calendar.SUNDAY
);
date.set(Calendar.HOUR, 0);
date.set(Calendar.MINUTE, 0);
date.set(Calendar.SECOND, 0);
date.set(Calendar.MILLISECOND, 0);
// Schedule to run every Sunday in midnight
timer.schedule(
  new SampleTask (myThread),
  date.getTime(),
  1000 * 60 * 60 * 24 * 7
);