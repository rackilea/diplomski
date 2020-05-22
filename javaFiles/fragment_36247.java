Calendar cal = Calendar.getInstance();
cal.setTime(date);
int hour = cal.get(Calendar.HOUR_OF_DAY);
int minutes = cal.get(Calendar.MINUTE);
if (hour == 10 && minutes >= 30 || hour == 11 && minutes <= 30) {
   ... 
}