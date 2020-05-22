import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;




public class readfile {
    private static Scanner ian;

    public static void main (String[]args) throws FileNotFoundException
    {
        Scan();
    }

    public static void Scan()
    {
        try
        {
            ian = new Scanner(new File("demo.txt"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        while(ian.hasNext())
        {

            int b = ian.nextInt();
            int c = ian.nextInt();
            int d = ian.nextInt();
            int e = ian.nextInt();
            int f = ian.nextInt();
            String a = ian.nextLine();

            System.out.printf("a : %s, b : %d, c : %d ,d : %d ,e  : %d, g : %d "  ,a,b,c,d,e,f);
        }
    }
}