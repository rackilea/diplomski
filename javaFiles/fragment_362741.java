public class DateTimeUtils {
  public static String toNicePeriodValue(Period period) {
    return period.getHours() + "hours " +
           period.getMinutes() + "minutes " +
           period.getSeconds() + "seconds " +
           period.getMillis() + "milliseconds";
  }
}