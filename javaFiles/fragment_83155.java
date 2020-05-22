import java.util.Arrays;
import java.util.List;

public class DaysAdder {

    int day=1;
    int month=1;
    int year=2014;

    public DaysAdder(int day, int month, int year) {
        super();
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void addDays(int x) {

        day = day + x;
        if (day > 29 && month == 2 && isLeapYear()) {
            day = day - 29;
            addMonths(1);
        } else if (day > 28 && month == 2 && !isLeapYear()) {
            day = day - 28;
            addMonths(1);
        } else if (day > 30 && !is31dayMonth()) {
            day = day - 30;
            addMonths(1);
        } else if (day > 31 && is31dayMonth()) {
            day = day - 31;
            addMonths(1);
        }
    }

    private boolean is31dayMonth() {
        List<Integer> month31 = Arrays.asList(1,3,5,7,8,10,12);
        return month31.contains(month);
    }

    private boolean isLeapYear() {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    private void addMonths(int i) {
        month = month + i;
        if (month >= 13) {
            addYear(1);
            month = month - 12;
        }
    }

    private void addYear(int i) {
        year = year + i;
    }

    @Override
    public String toString() {
        return "DaysAdder [day=" + day + ", month=" + month + ", year=" + year
                + "]";
    }

    public static void main(String[] args) {
        DaysAdder daysAdder = new DaysAdder(23, 2, 2016);
        daysAdder.addDays(7);
        System.out.println(daysAdder); //DaysAdder [day=1, month=3, year=2016]
        daysAdder = new DaysAdder(23, 2, 2014);
        daysAdder.addDays(7);
        System.out.println(daysAdder); //DaysAdder [day=2, month=3, year=2014]
    }
}