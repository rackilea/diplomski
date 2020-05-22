Calendar c = new GregorianCalendar();
c.setTime(new Date(0));

c.add(Calendar.DAY_OF_YEAR, 1000);

System.err.println(c.getTime());