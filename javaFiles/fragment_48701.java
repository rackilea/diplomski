public long daysBetween(Calendar startDate, Calendar endDate) {
   Calendar date = (Calendar) startDate.clone();
   long daysBetween = 0;
   while (date.before(endDate)) {
      date.add(Calendar.DAY_OF_MONTH, 1);
      daysBetween++;
   }}