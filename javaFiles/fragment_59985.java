public class Calendar{

    public static void main(String[] args) {
        // INSERT YOUR TESTS HERE
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysIn(int month, int year) {
        switch (month) {
            case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
                return 31; 
            case 4 : case 6 : case 9 : case 11 :
                return 30; 
            case 2:
                return isLeapYear(year) ? 29 : 28; 
            default:
                return -1;
        }
    }

    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", 
                "July", "August", "September", "October", "November", "December"};

        return month <= 12 && month > 0 ? months[month - 1] : "Invalid month";
    }

    public static int getStartDay(int month, int year) {
        int days = 0;

        for (int i = 1900; i < year; i++) {
            days += 365;
            if (isLeapYear(i)) {
                days = days + 1;
            }
        }

        for (int i = 1; i < month; i++) {
            days = days + getDaysIn(i, year);
        }
        int startday = (days % 7) + 2;
        return startday;
    }

    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int startDay = getStartDay(month, year);
        int monthDays = getDaysIn(month, year);

        System.out.println("   Sun   Mon   Tue   Wed   Thu   Fri   Sat");
        int weekDay = startDay - 1;
        for (int i = 1; i < startDay; i = i + 1) {
            System.out.print("      ");
        }
        for (int x = 1; x <= monthDays; x++) {
            weekDay = weekDay + 1;
            if (weekDay > 7) {
                System.out.println();
                weekDay = 1;
            }
            System.out.format("   %3d", x);
        }
        if (weekDay > 7) {
            System.out.println();
        }
    }

}