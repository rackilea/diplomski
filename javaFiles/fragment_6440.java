Date date = new Date();
 Calendar calendar = Calendar.getInstance();
 calendar.setTime(date);
 calendar.set(Calendar.HOUR_OF_DAY, 6);// for 6 hour
 calendar.set(Calendar.MINUTE, 0);// for 0 min
 calendar.set(Calendar.SECOND, 0);// for 0 sec
 System.out.println(calendar.getTime());// print 'Mon Mar 28 06:00:00 ALMT 2016'