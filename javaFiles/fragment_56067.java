import java.io.IOException;
import java.util.Scanner;

public class SOTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("File Name: ");

        // Get the file path and close scanner
        String file = in.next();
        in.close();

        try
        {
            Runtime.getRuntime().exec("notepad " + file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}