LocalDateTime start = LocalDateTime.of(2019, 1, 1, 12, 0, 0);
LocalDateTime end = LocalDateTime.of(2021, 4, 26, 5, 56, 40);

Duration d = Duration.between(start.toLocalTime(), end.toLocalTime());
Period p = Period.between(start.toLocalDate(), end.toLocalDate());

// If the startdate's time component lies behind the enddate's time component,
// then we need to correct both the Period and Duration
if (d.isNegative()) {
    p = p.minusDays(1);
    d = d.plusDays(1);
}

System.out.printf("y %s m %s d %s h %s m %s s %s%n",
    p.getYears(),
    p.getMonths(),
    p.getDays(),
    d.toHours() % 24,
    d.toMinutes() % 60,
    d.getSeconds() % 60);