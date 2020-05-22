String dateAsString = "16/09/2014";
DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Calendar c = Calendar.getInstance();
c.setTime(formatter.parse(dateAsString));

c.add(Calendar.DAY_OF_MONTH, 1);
System.out.println("After one day: " + formatter.format(c.getTimeInMillis()));
c.add(Calendar.DAY_OF_MONTH, -1);

c.add(Calendar.WEEK_OF_YEAR, 1);
System.out.println("After one week: " + formatter.format(c.getTimeInMillis()));
c.add(Calendar.WEEK_OF_YEAR, -1);

c.add(Calendar.MONTH, 1);
System.out.println("After one month: " + formatter.format(c.getTimeInMillis()));
c.add(Calendar.MONTH, -1);

c.add(Calendar.YEAR, 1);
System.out.println("After one year: " + formatter.format(c.getTimeInMillis()));
c.add(Calendar.YEAR, -1);