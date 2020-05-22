String[] input = { "01:10", "01:10", "01:10", "01:10", "01:10", "01:10" };
PeriodFormatter pf =
  new PeriodFormatterBuilder()
  .minimumPrintedDigits(2).printZeroAlways()
  .appendHours().appendLiteral(":").appendMinutes().toFormatter();
Period period = Period.ZERO;

for (String s : input) {
  period = period.plus(pf.parsePeriod(s));
}

System.out.println("duration=" + pf.print(period.normalizedStandard()));
// output: duration=07:00