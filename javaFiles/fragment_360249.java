import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Choose a number (Between 1 to 8)");
        Scanner sc=new Scanner(System.in);

        int a = sc.nextInt();
        if (a >= 1 && a <= 8)
            System.out.println("No. is valid");
        else
            System.out.println("Enter a valid number please");
    }
}