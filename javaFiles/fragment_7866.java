import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ErrorScanner
{
    public static void main(String[] args) throws FileNotFoundException 
    {
        Scanner s = new Scanner(new File("Users/home/test.txt"));
        boolean ifError = false;
        while(s.hasNextLine())
        {  
        String nextLine = s.nextLine();       
            if(nextLine.contains("ERROR"))
            {
                System.out.println("Failed" + " " + nextLine);
                ifError = true;
            }
        }     
        if(! ifError)
        {
            System.out.println("Nothing found");
        }
    }
}