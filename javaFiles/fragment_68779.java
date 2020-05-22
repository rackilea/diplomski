import java.util.Scanner;

public class Recursion
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter base: ");
        int baseNum = input.nextInt();

        System.out.println("Enter exponent: ");
        int expNum = input.nextInt();

        for (int i = 1; i <= expNum; ++i)
        {

            System.out.printf("\n%d to the %d", baseNum, i);

        }

        System.out.printf("\nValue is %d", power(baseNum, expNum));
    }

    public static int power(int base, int exponent)
    {
        if (exponent == 0)
        {
            return 1;
        }

        else
        {
            return base * power(base, exponent - 1);
        }
    }
}