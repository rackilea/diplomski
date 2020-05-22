public class number
{
    public static void main(String args [])
    {
        double d = 123456.78;
        DecimalFormat df = new DecimalFormat("###,### ");
        System.out.
        println(df.format(d));
    }
}