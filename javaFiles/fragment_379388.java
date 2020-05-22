import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        double number, t, squareRoot;
        Scanner input = new Scanner(System.in);
        number = input.nextDouble();
        squareRoot = number / 2;
        do
        {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        }
        while ((t - squareRoot) != 0);

        System.out.println(squareRoot);
    }
}