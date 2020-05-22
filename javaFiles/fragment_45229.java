import java.util.Scanner;
public class whileLoopOlympics
{
public static void main (String[] args)
{
    Scanner scanner = new Scanner(System.in);    
    int year = 0;


    while (year!=2012)
    {
        System.out.println ("Which year was the most recent London Olympics?");
        String yearAsString = scanner.nextLine();
        year = Integer.parseInt(yearAsString);
    }
}
}