public class Test
{
    public static void main(String[] args)
    {
        String x = "hello";
        String y = new String(x);
        System.out.println(x == y); // Prints false
    }
}