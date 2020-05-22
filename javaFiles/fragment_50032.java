SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
Calendar dt = Calendar.getInstance();

// Where untilDate is a date instance of your choice, for example 30/01/2012
dt.setTime(untilDate);

// If you want the event until 30/01/2012, you must add one day from our day because UNTIL in RRule sets events before the last day
dt.add(Calendar.DATE, 1);
String dtUntill = yyyyMMdd.format(dt.getTime());