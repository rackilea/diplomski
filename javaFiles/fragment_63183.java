import java.util.Scanner;
public class CurrencyConverter
{
    public static void main(String [ ] args)
    {        
        Scanner input = new Scanner(System.in);

        String pesos;
        System.out.println("What is the current exchange rate for pesos to dollars?");
        pesos = input.nextLine();

        String yen;
        System.out.println("What is the current exchange rate for yen to dollars?");
        yen = input.nextLine();

        String euros;
        System.out.println("What is the current exchange rate for euros to dollars?");
        euros = input.nextLine();
    }
}