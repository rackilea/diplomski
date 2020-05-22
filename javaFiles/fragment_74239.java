for(loop through months){
        LocalDate date = LocalDate.of(2014, month, 01);
        TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.WEDNESDAY);
        LocalDate nextWed = date.with(adj);
        LocalDate secondWed = nextWed.with(adj);
        LocalDate thirdWed = secondWed.with(adj);
        // save in map
}