public class Time {
public static void main(String[] args) {
    System.out.println(getNthOfMonth(DateTimeConstants.SUNDAY, DateTimeConstants.SEP, 2012));
}


public static LocalDate getNthOfMonth(int day_of_week, int month, int year) {
    LocalDate date = new LocalDate(year, month, 1).dayOfMonth()  
             .withMaximumValue()
             .dayOfWeek()
             .setCopy(day_of_week);
    if(date.getMonthOfYear() != month) {
        return date.dayOfWeek().addToCopy(-7);
    }
    return date;
}
}