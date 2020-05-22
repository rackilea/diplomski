public class Test
{
    public static void main(String[] args)
    {
        int index;

        for (index = 0; index < args.length; ++index)
        {
            System.out.println("args[" + index + "]: " + args[index]);
        }
    }
}