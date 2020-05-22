public static Calendar zeroCalendar(Calendar calendar)
{
   calendar.set(Calendar.HOUR, 0);
   calendar.set(Calendar.MINUTE, 0);    
   calendar.set(Calendar.SECOND, 0);
   calendar.set(Calendar.MILLISECOND, 0);
   return calendar;
 }