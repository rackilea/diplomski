static LocalDate oneDayBackExcludingWeekends(LocalDate date) {
    switch (date.getDayOfWeek()) {
        case DateTimeConstants.MONDAY:
            return date.minusDays(3);
        case DateTimeConstants.SUNDAY:
            return date.minusDays(2);
        default:
            return date.minusDays(1);
    }
}