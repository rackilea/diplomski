int dayOfWeek = Calendar.WEDNESDAY;
int hour      = 10; // 10 AM
int minute    = 0;

Calendar cal = Calendar.getInstance(); // Today, now
if (cal.get(Calendar.DAY_OF_WEEK) != dayOfWeek) {
    cal.add(Calendar.DAY_OF_MONTH, (dayOfWeek + 7 - cal.get(Calendar.DAY_OF_WEEK)) % 7);
} else {
    int minOfDay = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
    if (minOfDay >= hour * 60 + minute)
        cal.add(Calendar.DAY_OF_MONTH, 7); // Bump to next week
}
cal.set(Calendar.HOUR_OF_DAY, hour);
cal.set(Calendar.MINUTE, minute);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);

System.out.println(cal.getTime()); // Prints: Wed May 10 10:00:00 EDT 2017