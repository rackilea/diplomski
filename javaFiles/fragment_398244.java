public class DoubleTest
{
    public static void main(String[] args)
    {
        runTest(300, 324);
        runTest(300, 325);
        runTest(300, 326);
    }

    private static void runTest(int negativeExponent, int exponent)
    {
        String s = prefix(negativeExponent)+"1e"+exponent+"D";
        double d = Double.parseDouble(s);
        System.out.println(
            "For 1e-"+negativeExponent+" * 1e"+exponent+" result is "+d);
    }

    private static String prefix(int negativeExponent)
    {
        StringBuilder sb = new StringBuilder("0.");
        for (int i=0; i<negativeExponent; i++)
        {
            sb.append("0");
        }
        return sb.toString();
    }
}