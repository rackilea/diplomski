public class Test
{
    public static void main(String[] args)
    {
        String x = "hello";
        String y = "hel" + "lo"; // Concatenated at compile-time
        System.out.println(x == y); // Prints true
    }
}