import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

class Main{
  private static final Locale DUTCH = new Locale("nl","NL");

  public static void main(String[] a){
    test("11", Locale.ENGLISH);
    test("11", DUTCH);
    System.out.println();
    test("11.00", Locale.ENGLISH);
    test("11.00", DUTCH);
    System.out.println();
    test("11,00", Locale.ENGLISH);
    test("11,00", DUTCH);
    System.out.println();
    test("15.123", Locale.ENGLISH);
    test("15.123", DUTCH);
    System.out.println();
    test("15,123", Locale.ENGLISH);
    test("15,123", DUTCH);
    System.out.println();
    test("something", Locale.ENGLISH);
    test("something", DUTCH);
  }

  static void test(String val, Locale locale){
    try{
      DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
      char decimalSep = symbols.getDecimalSeparator();
      char thousandSep = symbols.getGroupingSeparator();

      String escapedDecimalSep = decimalSep == '.' ? "\\." : decimalSep+"";
      String escapedThousandSep = thousandSep == '.' ? "\\." : thousandSep+"";

      String intRegex = "\\d+(" + escapedThousandSep + "\\d{3})*"; // Example ENGLISH: "\\d+(,\\d{3})*"
      String doubleRegex = intRegex + escapedDecimalSep + "\\d+"; // Example ENGLISH: "\\d+(,\\d{3})*\\.\\d+"

      NumberFormat format = NumberFormat.getInstance(locale);
      Number number = format.parse(val);
      if(val.matches(doubleRegex)){
        double d = number.doubleValue();
        System.out.println(val + " (in locale " + locale + ") is a double: " + d);
      } else if(val.matches(intRegex)){
        int i = number.intValue();
        System.out.println(val + " (in locale " + locale + ") is an integer: " + i);
      } else{
        System.out.println("Unable to determine whether value " + val + " is an integer or double for locale " + locale);
      }
    } catch(ParseException ex){
      System.out.println("Error occurred for value \"" + val + "\". Are you sure it's an integer or decimal?");
    }
  }
}