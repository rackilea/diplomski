private LocalDateTime calcNextSunday(LocalDateTime d) {
    return d.withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).withDayOfWeek(DateTimeConstants.SUNDAY);
}

private LocalDateTime calcPreviousMonday(final LocalDateTime d) {
    return d.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withDayOfWeek(DateTimeConstants.MONDAY);
}