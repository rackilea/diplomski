public class DateUtils {
  public static org.joda.time.DateTime makeJodaFromSWT(
                                org.eclipse.swt.widgets.DateTime widget) {
    return new DateTime(widget.getYear(),
                        widget.getMonth(),
                        widget.getDay(),
                        widget.getHours(),
                        widget.getMinutes(),
                        widget.getSeconds());
  }

  public static void updateSWTwithJoda(
                                org.eclipse.swt.widgets.DateTime widget,
                                org.joda.time.DateTime dateTime) {
    widget.setYear(dateTime.getYear());
    widget.setMonth(dateTime.getMonthOfYear());
    widget.setDay(dateTime.getDayOfMonth());
    widget.setHours(dateTime.getHourOfDay());
    widget.setMinutes(dateTime.getMinuteOfHour());
    widget.setSeconds(dateTime.getSecondOfMinute());
  }
}