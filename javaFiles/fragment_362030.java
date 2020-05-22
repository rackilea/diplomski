LocalDate today = LocalDate.now(ZoneId.of("Europe/Moscow"));
    LocalDate firstDayOfWeek 
            = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    System.out.println("This year: " + firstDayOfWeek + " - " + today);

    LocalDate firstDayLastYear = firstDayOfWeek.minusWeeks(52);
    LocalDate correspondingDayLastYear = today.minusWeeks(52);
    System.out.println("Last year: " + firstDayLastYear + " - "
                        + correspondingDayLastYear);