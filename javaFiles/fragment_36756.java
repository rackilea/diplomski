LocalDate date = LocalDate.now(ZoneId.of("Asia/Colombo"));
    System.out.println(date);

    WeekFields wf = WeekFields.ISO;
    // set to first day of week (Monday for ISO, Sunday for USA)
    date = date.with(wf.dayOfWeek(), 1);

    System.out.println(date);