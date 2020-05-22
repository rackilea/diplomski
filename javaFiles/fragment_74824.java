public class NumberOnly
{
    public static void main (String [] args)
    {

        for(int i=1; i<=5; i++)
        {
            for(int j=1; j<=10; j++)
            {
                System.out.print((int)Math.round(Math.pow(j, i)) + " ");
            }
            System.out.println();
        }
    }
}