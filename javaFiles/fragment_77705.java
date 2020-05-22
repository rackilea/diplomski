LocalDate saturday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
LocalDate wednesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));

long result;
if(saturday.isBefore(wednesday)){
    result = getMillSecond(DayOfWeek.SATURDAY);
}
result = getMillSecond(DayOfWeek.WEDNESDAY);