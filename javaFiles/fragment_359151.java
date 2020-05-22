import java.util.Locale;
import java.text.*;

class Main {
  public static void main(String[] args) throws ParseException {
    String v1 = "84,21834324";
    String v2 = "1.234.567,89";

    NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
    Number n1 = format.parse(v1);
    Number n2 = format.parse(v2);

    double d1 = n1.doubleValue();
    double d2 = n2.doubleValue();
  }
}