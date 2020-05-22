// parse the date
Date date = parser.parse("11/17");
// set to a Calendar
Calendar cal = Calendar.getInstance();
cal.setTime(date);
// change to whatever day you want
cal.set(Calendar.DAY_OF_MONTH, whateverDayIwant);
// format it
System.out.println(formatter.format(cal.getTime()));