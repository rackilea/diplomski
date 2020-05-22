Calendar rightNow = Calendar.getInstance();
Calendar cal = new GregorianCalendar(
   rightNow.get(YEAR),
   rightNow.get(MONTH),
   rightNow.get(DAY_OF_MONTH));
Date now = cal.getTime();