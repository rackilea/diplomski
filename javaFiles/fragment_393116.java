PaxChronology paxCal = PaxChronology.INSTANCE;
System.out.println("month range: " + paxCal.range(ChronoField.MONTH_OF_YEAR));

PaxDate pd = paxCal.date(1930, 1, 1);
for (int i = 0; i < 15; i++) {
    // fmt is the same DateTimeFormatter from previous example
    System.out.println(fmt.format(pd));
    // adjusting for first day of next month - using TemporalAdjuster because
    // adding 1 ChronoUnit.MONTHS throws an exception for 14th month (not sure why)
    pd = pd.plus(30, ChronoUnit.DAYS).with(TemporalAdjusters.firstDayOfMonth());
}