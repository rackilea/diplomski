String text = "1999-12-31 12:59:59 +02:00";

    TemporalAccessor parsed = DATE_TIME.parseBest(text,
            OffsetDateTime::from, ZonedDateTime::from, LocalDateTime::from);

    System.out.println(parsed.getClass());
    System.out.println(parsed);