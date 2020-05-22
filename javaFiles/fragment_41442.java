final Calendar reportingDate = Calendar.getInstance();
reportingDate.set(Calendar.YEAR, 2013);
reportingDate.set(Calendar.MONTH, Calendar.MARCH);
reportingDate.set(Calendar.DAY_OF_MONTH, 10);

final Calendar targetTime = Calendar.getInstance();
targetTime.set(Calendar.AM_PM, Calendar.AM);
targetTime.set(Calendar.HOUR_OF_DAY, 3);
targetTime.set(Calendar.MINUTE, 0);
targetTime.set(Calendar.SECOND, 0);
targetTime.set(Calendar.MILLISECOND, 0);

final Calendar combination = Calendar.getInstance();
combination.set(Calendar.YEAR, reportingDate.get(Calendar.YEAR));
combination.set(Calendar.MONTH, reportingDate.get(Calendar.MONTH));
combination.set(Calendar.DAY_OF_YEAR, reportingDate.get(Calendar.DAY_OF_YEAR));
combination.set(Calendar.HOUR, targetTime.get(Calendar.HOUR));
combination.set(Calendar.AM_PM, targetTime.get(Calendar.AM_PM));
combination.set(Calendar.MINUTE, targetTime.get(Calendar.MINUTE));
combination.set(Calendar.SECOND, targetTime.get(Calendar.SECOND));
combination.set(Calendar.MILLISECOND, targetTime.get(Calendar.MILLISECOND));

final long timeAtCombined = combination.getTimeInMillis();

final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSSZ");
sdf.setTimeZone(TimeZone.getTimeZone("US/Eastern"));

// subtract one minute
System.out.println(sdf.format(combination.getTime()));
combination.add(Calendar.MILLISECOND, -1);
System.out.println(sdf.format(combination.getTime()));

// millis @ 3
System.out.println(sdf.format(new Date(timeAtCombined)));
// millis @ 3 - 1ms
System.out.println(sdf.format(new Date(timeAtCombined - 1)));