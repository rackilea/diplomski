public static LocalDate autocomplete(String mmdd) {
    ZoneId clientTimeZone = ZoneId.systemDefault();
    LocalDate today = LocalDate.now(clientTimeZone);
    MonthDay md = MonthDay.parse(mmdd, DateTimeFormatter.ofPattern("MM-dd"));
    Year y = Year.from(today);
    if (md.isBefore(MonthDay.from(today))) {
        // in the past; use next year
        y = y.plusYears(1);
    }
    return y.atMonthDay(md);
}