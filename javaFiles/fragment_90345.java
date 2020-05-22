Calendar c = Calendar.getInstance();
c.setFirstDayOfWeek(Calendar.MONDAY);

c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
c.set(Calendar.HOUR_OF_DAY, 0);
c.set(Calendar.MINUTE, 0);
c.set(Calendar.SECOND, 0);
c.set(Calendar.MILLISECOND, 0);

Date monday = c.getTime();

Date nextMonday= new Date(monday.getTime()+7*24*60*60*1000);

boolean isThisWeek = date2.after(monday) && date2.before(nextMonday);