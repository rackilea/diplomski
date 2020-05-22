private static class CheckEveryDayBase implements CheckInterface{
    private String StartDate;
    private String EndDate;
    private int Interval;
    private int HolidayCondition;
}

private static class CheckSpecificDday implements CheckInterface{
    private String SpecificDay;
    private int Lunar;
}

private static class CheckEveryDayDday extends CheckEveryDayBase{
    private String StartOption;
}

private static class CheckEveryDdayOfWeek extends CheckEveryDayBase{
    private String SpecificDayOfWeek;
}

private static class CheckEveryMonthSpecificDday extends CheckEveryDayBase{
    private String SpecificDD;
}

private static class CheckEveryYearWeek extends CheckEveryDayBase{
    private String SpecificMMnthWeek;
}