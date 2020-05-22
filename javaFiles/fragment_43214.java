public class App {
  public static void main(String[] args) {
    try {
        System.out.println(convertTo24HoursFormat("12:00AM")); // 00:00
        System.out.println(convertTo24HoursFormat("12:00PM")); // 12:00
        System.out.println(convertTo24HoursFormat("11:59PM")); // 23:59
        System.out.println(convertTo24HoursFormat("9:30PM"));  // 21:30
    } catch (ParseException ex) {
        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  // Replace with KK:mma if you want 0-11 interval
  private static final DateFormat TWELVE_TF = new SimpleDateFormat("hh:mma");
  // Replace with kk:mm if you want 1-24 interval
  private static final DateFormat TWENTY_FOUR_TF = new SimpleDateFormat("HH:mm");

  public static String convertTo24HoursFormat(String twelveHourTime)
        throws ParseException {
    return TWENTY_FOUR_TF.format(
            TWELVE_TF.parse(twelveHourTime));
  }
}