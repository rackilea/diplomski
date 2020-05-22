import java.text.*;

public class Test {

    public static void main(String[] args) throws ParseException {

        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setGroupingSeparator('.');
        dfs.setDecimalSeparator(',');

        DecimalFormat df = new DecimalFormat();
        df.setGroupingSize(3);

        String[] tests = { "15,151.11", "-7,21.3", "8.8" };
        for (String test : tests)
            System.out.printf("\"%s\" -> %f%n", test, df.parseObject(test));
    }
}