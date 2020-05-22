System.out.println(getPreviousWorkingDay(Collections.emptyList()));
    // Let’s say Valentin’s day is a holiday
    System.out.println(getPreviousWorkingDay(List.of(MonthDay.of(Month.FEBRUARY, 14))));
    // And so are Lent Monday and the death day of Danish would-be king Henrik 
    System.out.println(getPreviousWorkingDay(List.of(MonthDay.of(Month.FEBRUARY, 12), 
            MonthDay.of(Month.FEBRUARY, 13), MonthDay.of(Month.FEBRUARY, 14))));