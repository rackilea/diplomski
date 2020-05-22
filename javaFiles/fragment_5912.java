Calendar cal = Calendar.getInstance();
cal.setTimeInMillis(1513213212* 1000L);
cal.setTimeZone(TimeZone.getTimeZone("UTC"));

System.out.println(cal.get(Calendar.HOUR));//12 hour clock
System.out.println(cal.get(Calendar.HOUR_OF_DAY));//24 hour clock