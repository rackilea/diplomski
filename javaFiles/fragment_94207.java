private String getDate(long value) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime start = LocalDateTime.of(1970, 1, 1, 0, 0, 0, 0);
    LocalDateTime lastWeek = now.minusDays(6);
    LocalDateTime date = start.plus(value, ChronoUnit.MILLIS);

    if (lastWeek.isBefore(date)) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == now.getDayOfWeek()) {
            return "Today";
        } else {
            return dayOfWeek.name();
        }
    } 


    return date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
}