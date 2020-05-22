LocalDate start = LocalDate.of(2019, 11, 10);
LocalDate end = LocalDate.of(2019, 11, 11);

LocalDate mondayStart = start.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
LocalDate mondayEnd = end.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

System.out.println(ChronoUnit.WEEKS.between(mondayStart, mondayEnd));