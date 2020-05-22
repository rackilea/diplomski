ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Europe/Paris"));//Or any zone time
ZonedDateTime nextSaturday = now
        .with(TemporalAdjusters.next(DayOfWeek.SATURDAY))
        .with(LocalTime.of(20, 0));
long millSeconds = ChronoUnit.MILLIS.between(now, nextSaturday);

System.out.println(now);           //2018-07-05T18:25:10.377511100+02:00[Europe/Paris]
System.out.println(nextSaturday);  //2018-07-07T20:00+02:00[Europe/Paris]
System.out.println(millSeconds);   //178489622