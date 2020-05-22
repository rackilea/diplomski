import java.math.BigInteger;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NumberNames
{
    public static void main(String[] args)
    {
        test("100", "Nearly nothing");
        test("1000", "1 Thousand");
        test("1230", "1.23 Thousand");
        test("1000000", "1 Million");
        test("1435234", "1.43 Million");
        test("350000000", "350 Million");
        test("1000000000", "1 Billion");
        test("1765000000", "1.76 Billion");
        test("1000000000000", "1 Trillion");
        test("1345342345000", "1.34 Trillion");
        test("1000000000000000", "1 Quadrillion");
        test("100000000000000000", "100 Quadrillion");
        test("1230000000000000000000000000000000000000000000000000000000000000", "1.23 Vigintillion");
    }

    private static void test(String numberString, String string)
    {
        BigInteger number = new BigInteger(numberString);
        System.out.println(number+" is "+createString(number)+" should be "+string);
    }



    private static final String NAMES[] = new String[]{
        "Thousand",
        "Million",
        "Billion",
        "Trillion",
        "Quadrillion",
        "Quintillion",
        "Sextillion",
        "Septillion",
        "Octillion",
        "Nonillion",
        "Decillion",
        "Undecillion",
        "Duodecillion",
        "Tredecillion",
        "Quattuordecillion",
        "Quindecillion",
        "Sexdecillion",
        "Septendecillion",
        "Octodecillion",
        "Novemdecillion",
        "Vigintillion",
    };
    private static final BigInteger THOUSAND = BigInteger.valueOf(1000);
    private static final NavigableMap<BigInteger, String> MAP;
    static
    {
        MAP = new TreeMap<BigInteger, String>();
        for (int i=0; i<NAMES.length; i++)
        {
            MAP.put(THOUSAND.pow(i+1), NAMES[i]);
        }
    }

    public static String createString(BigInteger number)
    {
        Entry<BigInteger, String> entry = MAP.floorEntry(number);
        if (entry == null)
        {
            return "Nearly nothing";
        }
        BigInteger key = entry.getKey();
        BigInteger d = key.divide(THOUSAND);
        BigInteger m = number.divide(d);
        float f = m.floatValue() / 1000.0f;
        float rounded = ((int)(f * 100.0))/100.0f;
        if (rounded % 1 == 0)
        {
            return ((int)rounded) + " "+entry.getValue();
        }
        return rounded+" "+entry.getValue();
    }
}