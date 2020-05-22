import java.util.Scanner;

public class ScannerTest
{
    public static void main(String[] args)
    {
        String input = "Some\ttab delimited\tstring\twhere\tsome words\tare\tseparated\tby spaces.";
        Scanner sc = new Scanner(input).useDelimiter("\\t");
        while (sc.hasNext())
        {
            System.out.println(sc.next());
        }
        sc.close();
    }
}