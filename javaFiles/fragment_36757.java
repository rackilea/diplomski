WeekFields wf = WeekFields.ISO;
    date = date.with(wf.dayOfWeek(), 1);

    System.out.println(date);

    LocalDate[] days = new LocalDate[7];
    for (int i = 0; i < 7; i++) {

        days[i] = date;
        date = date.plusDays(1);

        System.out.println("List days " + "" + days[i]);
    }