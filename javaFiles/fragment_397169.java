import java.util.Scanner;

public class GetValues
{
    private static Scanner inp = new Scanner(System.in);
    private static String z = "";
    public static void wew()
    {
        System.out.println("Enter name: ");
        String a = inp.nextLine();
        z = a;
    }
    public static String kuhaName()
    {
        return z;
    }
}