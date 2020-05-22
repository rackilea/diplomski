Calendar c1 = Calendar.getInstance(); // August  16th, 2012 AD
c1.set(Calendar.YEAR, 0);             // August  16th,    0 AD
c1.set(Calendar.DAY_OF_YEAR, 1);      // January  1st,    0 AD
Date d1 = c1.getTime();               // January  1st,    1 BC (corrected)

Calendar c2 = Calendar.getInstance();
c2.setTime(d1);
c2.set(Calendar.YEAR, 2001);          // January  1st, 2001 BC
c2.set(Calendar.DAY_OF_YEAR, 1);
System.out.println(c2.getTime());     // prints "Wed Jan 01 05:35:00 CET 2001"
                                      // because 01/01/2001 BC was a Wednesday