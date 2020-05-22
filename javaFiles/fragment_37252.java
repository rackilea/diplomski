public class GregorianDate {

    private final int day;
    private final int month;
    private final int year;

    private static final int[] DAYS_PER_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public GregorianDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValid() {
        return month >= 1 && month <= 12 && day >= 1 && day <= daysThisMonth();
    }

    public static int daysBetween(GregorianDate from, GregorianDate to) {
        return to.dayNumber() - from.dayNumber();
    }

    public static int daysBetween(int fromDay, int fromMonth, int fromYear, int toDay, int toMonth, int toYear) {
        return daysBetween(new GregorianDate(fromDay, fromMonth, fromYear), new GregorianDate(toDay, toMonth, toYear));
    }

    private int daysThisMonth() {
        return (isLeapYear() && month == 2) ? 29 : DAYS_PER_MONTH[month];
    }

    private int dayNumber() {
        return year * 365 + leapYearsBefore() + daysInMonthsBefore() + day;
    }

    private boolean isLeapYear() {
        return ( year % 4 == 0 &&  year % 100 != 0 ) || year % 400 == 0;  
    }

    private int leapYearsBefore() {
        return year / 4 - year / 100 + year / 400;
    }

    private int daysInMonthsBefore() {
        switch(month) {
        case 1: 
            return 0;
        case 2:
            return 31;
        default:
            // Start with the number in January and February combined
            int toReturn = isLeapYear() ? 60 : 59; 
            for (int monthToConsider = 3; monthToConsider < month; monthToConsider++) {
                toReturn += DAYS_PER_MONTH[monthToConsider];
            }
            return toReturn;
        }
    }

}