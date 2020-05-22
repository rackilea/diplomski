static void genDataforPeriodsTable(LocalDate endDate) {
    String sql = "SELECT MAX(WeekEnding) FROM Periods";
    LocalDate maxWeekEnding = /* Result of running query */;
    genDataforPeriodsTable(maxWeekEnding.plusDays(1), endDate);
}

static void genDataforPeriodsTable(LocalDate startDate, LocalDate endDate) {
    System.out.println("Year Period WeekStarting WeekEnding");
    System.out.println("==== ====== ============ ==========");
    for (LocalDate tempdate = startDate.with(nextOrSame(SUNDAY));
                   tempdate.compareTo(endDate) <= 0;
                   tempdate = tempdate.plusDays(7)) {
        int year = tempdate.getYear();
        int period = tempdate.minusDays(3).getMonthValue();
        LocalDate weekStarting = tempdate.minusDays(6);
        LocalDate weekEnding = tempdate;
        System.out.printf("%4d %-6d %-12s %s%n", year, period, weekStarting, weekEnding);
    }
}