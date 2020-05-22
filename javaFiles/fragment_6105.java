ZoneId zone = ZoneId.of("Africa/Bamako");
    LocalDate today = LocalDate.now(zone);
    LocalDate nextBookingDate = today.with(Month.JANUARY)
            .with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.MONDAY));
    if (nextBookingDate.isBefore(today)) {
        // Take next year instead
        nextBookingDate = today.plusYears(1)
                .with(Month.JANUARY)
                .with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.MONDAY));
    }

    System.out.println("Next booking date: " + nextBookingDate);