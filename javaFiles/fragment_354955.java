Calendar calStartofDay = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
calStartofDay.set(Calendar.YEAR, 2017);
calStartofDay.set(Calendar.MONTH, 0);
calStartofDay.set(Calendar.DAY_OF_MONTH, 21);
calStartofDay.set(Calendar.HOUR_OF_DAY, 00);
calStartofDay.set(Calendar.MINUTE, 0);
calStartofDay.set(Calendar.SECOND, 1);            

Calendar calBST = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
calBST.setTimeInMillis(calStartofDay.getTimeInMillis());
// use this to check the time
System.out.printf("%tc%n", calBST);