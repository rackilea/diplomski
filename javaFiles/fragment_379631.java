private static String getNthWeekday(int day) {

    Weekdays[] days = Weekdays.values();

    if (day >= days.length) {
        return days[day - days.length].name();
    } else {
        return days[day].name();
    }

}