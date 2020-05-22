PlainDate dtStart = PlainDate.of(2016, Month.FEBRUARY, 4);
    int count = 5;
    Weekday byday = Weekday.FRIDAY; // first
    int interval = 1;
    CalendarUnit frequency = CalendarUnit.MONTHS;

    List<PlainDate> sequence = new ArrayList<>(count);
    PlainDate wim = dtStart;
    for (int i = 0; i < count; i++) {
        wim = wim.with(PlainDate.WEEKDAY_IN_MONTH.setToFirst(byday));
        sequence.add(wim);
        wim = wim.with(PlainDate.DAY_OF_MONTH, 1).plus(interval, frequency);
    }
    if (!sequence.isEmpty() && !sequence.get(0).equals(dtStart)) {
        sequence.remove(0); // Not quite sure - do you need another condition?
    }
    System.out.println(sequence); // [2016-03-04, 2016-04-01, 2016-05-06, 2016-06-03]