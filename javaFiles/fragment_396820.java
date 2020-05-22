public class DateFormatTest {
  public static void main(String[] args) {
    // should be false
    System.out.println(isDateValid("19/06/2012 5:00, 21:00", "dd/MM/yyyy HH:mm"));
    System.out.println(isDateValid("19/06/201", "dd/MM/yyyy HH:mm"));

    System.out.println();

    // should be true
    System.out.println(isDateValid("19/06/2012 5:00", "dd/MM/yyyy HH:mm"));
  }

  public static boolean isDateValid(String date, String dateFormat) {
    ParsePosition pos = new ParsePosition(0);
    DateFormat df = new SimpleDateFormat(dateFormat);
    df.setLenient(false);
    df.parse(date, pos);

    return pos.getIndex() == date.length();
  }
}