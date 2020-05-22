public class TimeUtils {

  private static final PeriodFormatter HH_MM_FORMATTER = new PeriodFormatterBuilder()
    .printZeroAlways()
    .minimumPrintedDigits(2)
    .appendHours()
    .appendSeparator(":")
    .printZeroAlways()
    .minimumPrintedDigits(2)
    .appendMinutes()
    .toFormatter();

  private static final PeriodFormatter DD_HH_MM_FORMATTER = new PeriodFormatterBuilder()
    .printZeroAlways()
    .minimumPrintedDigits(2)
    .appendDays()
    .appendSeparator(":")
    .printZeroAlways()
    .minimumPrintedDigits(2)
    .appendHours()
    .appendSeparator(":")
    .printZeroAlways()
    .minimumPrintedDigits(2)
    .appendMinutes()
    .toFormatter();

  public static String addHhMmPeriods(List<String> hhMmPeriods) {
    Period total = new Period();
    for (String hhMmPeriod : hhMmPeriods) {
      total = total.plus(HH_MM_FORMATTER.parsePeriod(hhMmPeriod));
    }
    return total.normalizedStandard().toString(DD_HH_MM_FORMATTER);
  }
}