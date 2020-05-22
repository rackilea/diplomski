import java.text.DecimalFormat;
import java.text.ParsePosition;

public class TestP {

    public static void main(String[] args) {


        DecimalFormat decimalFormat = new DecimalFormat("00.##'money'");

        String search = "Giveme10.25moneyplease";

        int index = 6;
        //output 10.25
       Number number = decimalFormat.parse(search, new ParsePosition(index));

    if (number != null) {
        String s = number.toString();           
        if (s.contains(".") && s.length() > 5) {
            number = null;
        }
    }
    System.out.println(number);

    }

}