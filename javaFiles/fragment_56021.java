Locale russia = Locale.forLanguageTag("ru-RU");
    WeekFields wf = WeekFields.of(russia);

    LocalDate date = LocalDate.now(ZoneId.of("Europe/Moscow"));
    int minimumWeekOfMonth = date.with(TemporalAdjusters.firstDayOfMonth()).get(wf.weekOfMonth());
    System.out.println("Minimum week of month: " + minimumWeekOfMonth);
    LocalDate dateInFirstWeekOfMonth = date.with(wf.weekOfMonth(), minimumWeekOfMonth);
    System.out.println("Date in first week of month: " + dateInFirstWeekOfMonth);