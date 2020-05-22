public class Prac 
{
    public static void main (String[] args)

    {
        for (int line = 7; line >= 1; line = line - 2)
        {
            for(int stars = 1; stars < line; stars++)
            {
                System.out.print("*");
            }
            if((line-2) > 0)System.out.println();
        }
    }
}