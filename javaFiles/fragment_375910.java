TimeZone.setDefault(TimeZone.getTimeZone("GMT-1"));

Calendar c = new GregorianCalendar();
c.setTimeInMillis(0);

System.err.println(c.getTime());
System.err.println(c.get(Calendar.DAY_OF_YEAR));

c.add(Calendar.DAY_OF_YEAR, 1);
System.err.println(c.getTime());
System.err.println(c.get(Calendar.DAY_OF_YEAR));