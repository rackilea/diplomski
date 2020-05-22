public static long getTimeStampAt0000(long timestamp) {
  Calendar givenDate = Calendar.getInstance();
  givenDate.setTimeInMillis(timestamp);
  givenDate.set(Calendar.HOUR_OF_DAY, 0);
  givenDate.set(Calendar.MINUTE, 0);
  givenDate.set(Calendar.SECOND, 0);
  givenDate.set(Calendar.MILLISECOND, 0);
  return givenDate.getTimeInMillis();
}

public static long getTimeStampAt0000ForTomorrow() {
  long now = System.currentTimeMillis();
  long nowAt0000 = getTimeStampAt0000(now);
  if (now == nowAt0000) {
    // if being queried at 00:00, we are assuming we want same or else we can just remove
    // this condition
     return nowAt0000;
  } else {
     return nowAt0000 + 86400000;
  }
}