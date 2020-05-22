Calendar cal = Calendar.getInstance();
 cal.set(Calendar.HOUR_OF_DAY, 0);
 cal.set(Calendar.MINUTE, 0);
 cal.set(Calendar.SECOND, 0);
 cal.set(Calendar.MILLISECOND, 0)

 Date startDate = cal.getTime();
 cal.set(Calendar.HOUR_OF_DAY, 23);
 cal.set(Calendar.MINUTE, 59);
 cal.set(Calendar.SECOND, 59);
 cal.set(Calendar.MILLISECOND, 999)
 Date endDate = cal.getTime();