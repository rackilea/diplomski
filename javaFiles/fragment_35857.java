private static final DateTimeFormatter dateFormatter
        = DateTimeFormatter.ofPattern("uuuu_MM_dd");

public static String getPreviousWorkingDay(List<MonthDay> listOfHolidays) {
    LocalDate workingDay = LocalDate.now(ZoneId.of("Pacific/Easter")).minusDays(1);
    while (workingDay.getDayOfWeek().equals(DayOfWeek.SATURDAY) 
            || workingDay.getDayOfWeek().equals(DayOfWeek.SUNDAY)
            || listOfHolidays.contains(MonthDay.from(workingDay))) {
        workingDay = workingDay.minusDays(1);
    }
    return workingDay.format(dateFormatter);
}