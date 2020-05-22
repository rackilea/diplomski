// get today and clear time of day
Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
cal.clear(Calendar.MINUTE);
cal.clear(Calendar.SECOND);
cal.clear(Calendar.MILLISECOND);

// get start of the month
cal.set(Calendar.DAY_OF_MONTH, 1);
System.out.println("Start of the month:       " + cal.getTime());
System.out.println("... in milliseconds:      " + cal.getTimeInMillis());

// get start of the next month
cal.add(Calendar.MONTH, 1);
System.out.println("Start of the next month:  " + cal.getTime());
System.out.println("... in milliseconds:      " + cal.getTimeInMillis());