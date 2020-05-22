String[] input = { "12:00", "12:10" };
PeriodFormatter parser =
  new PeriodFormatterBuilder()
  .appendHours().appendLiteral(":")
  .appendMinutes().toFormatter();
Period period = Period.ZERO;

for (String s : input) {
  period = period.plus(parser.parsePeriod(s));
}

PeriodFormatter printer =
  new PeriodFormatterBuilder()
  .printZeroAlways().minimumPrintedDigits(2)
  .appendDays().appendLiteral(":")
  .appendHours().appendLiteral(":")
  .appendMinutes().toFormatter();
System.out.println("duration=" + printer.print(period.normalizedStandard()));
// output: duration=01:00:10