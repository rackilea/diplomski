public class DateUtilities {
    static Calendar calendar = Calendar.getInstance();
    public static long getPreviousDate(long currentDate){
        calendar.setTime(new Date(currentDate));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
        return calendar.getTime().getTime();
    }
    public static long getNextDate(long currentDate){
        calendar.setTime(new Date(currentDate));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        return calendar.getTime().getTime();
    }
}