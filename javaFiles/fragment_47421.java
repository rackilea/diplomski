public static Date getNearestDate(List<Date> dates, Date currentDate) {
  long minDiff = -1, currentTime = currentDate.getTime();
  Date minDate = null;
  for (Date date : dates) {
    long diff = Math.abs(currentTime - date.getTime());
    if ((minDiff == -1) || (diff < minDiff)) {
      minDiff = diff;
      minDate = date;
    }
  }
  return minDate;
}