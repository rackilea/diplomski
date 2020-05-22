OffsetDateTime utcDateTime = OffsetDateTime.now(ZoneOffset.UTC);

    if (utcDateTime.getDayOfMonth() >= 29) {
        utcDateTime = utcDateTime.withDayOfMonth(28);
    } 

    utcDateTime = utcDateTime.plusMonths(1);
    Timestamp time = Timestamp.from(utcDateTime.toInstant());
    System.out.println(time); // DB insert here