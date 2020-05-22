LocalDate utcDate = LocalDate.now(ZoneOffset.UTC);
    if (utcDate.getDayOfMonth() > 28) {
        utcDate = utcDate.withDayOfMonth(28);
    }
    utcDate = utcDate.plusMonths(1);
    Date date = Date.valueOf(utcDate);
    System.out.println(date); // DB insert here