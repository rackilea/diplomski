static long daysBetween(LocalDate start, LocalDate end, List<DayOfWeek> ignore) {
    if(ignore.isEmpty()) return start.until(end, ChronoUnit.DAYS);
    EnumSet<DayOfWeek> set = EnumSet.copyOf(ignore);
    return start.datesUntil(end)
        .filter(d->!ignore.contains(d.getDayOfWeek()))
        .count();
}