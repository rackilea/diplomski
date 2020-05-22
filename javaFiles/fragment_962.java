public class EclipseBug
{
    private static int count = 781;
    public static void main(String[] args)
    {
        for (int i=0; i<count; i++)
            System.out.print("hello ");
        System.out.println();
    }
}