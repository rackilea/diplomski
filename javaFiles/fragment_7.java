static long daysBetween(LocalDate start, LocalDate end, List<DayOfWeek> ignore) {
    return Stream.iterate(start, d->d.plusDays(1))
                 .limit(start.until(end, ChronoUnit.DAYS))
                 .filter(d->!ignore.contains(d.getDayOfWeek()))
                 .count();
}