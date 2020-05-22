Date startDate = new GregorianCalendar(2020, 0, 18).getTime(); //(year, month - 1, day)

Calendar cal = Calendar.getInstance();
cal.setTime(startDate );
cal.set(Calendar.MONTH, Calendar.MARCH);// change to month you want 
System.out.println(cal.getTime());