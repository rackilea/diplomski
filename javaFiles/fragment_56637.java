public Date getThisDateInThisYear(Date date) {
   Calendar c = Calendar.getInstance();
   int thisYear = c.get(Calendar.YEAR)
   c.setTime(date);

   int diff = thisYear  - c.get(Calendar.YEAR);
   c.add(Calendar.YEAR, diff);

   return c.getTime();

}