Calendar c1 = Calendar.getInstance(); // today
c1.add(Calendar.DAY_OF_YEAR, -1); // yesterday

Calendar c2 = Calendar.getInstance();
c2.setTime(getDateFromLine(line)); // your date

if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
  && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR)) {