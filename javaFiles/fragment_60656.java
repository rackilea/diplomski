static LocalDate oneDayBackExcludingWeekends(LocalDate date) {
    do {
        date = date.minusDays(1);
    } while (date.getDayOfWeek() == DateTimeConstants.SUNDAY ||
             date.getDayOfWeek() == DateTimeConstants.SATURDAY); 
    return date;
}