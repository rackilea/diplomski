import java.util.Formatter;

final public class Main
{    
    public static void main(String[] args)
    {
        Formatter fmt = new Formatter();
        fmt.format("|%10.2f|", 123.123);
        System.out.println(fmt);

        fmt = new Formatter();
        fmt.format("|%10.2f|", 1.13);
        System.out.println(fmt);

        fmt = new Formatter();
        fmt.format("|%10.2f|", 152123.16777);
        System.out.println(fmt);

        fmt = new Formatter();
        fmt.format("|%10.2f|", 99.777);
        System.out.println(fmt);
    }
}