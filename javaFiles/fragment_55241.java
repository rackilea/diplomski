import java.util.Scanner;
public class Lottery
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
String lotteryNumberString = null;
for(int i=0; i < 3; i++)
{
    double lotto = Math.random();
    int lotteryNumberDigit = (int)(lotto*10);

    lotteryNumberString = Integer.toString(lotteryNumberDigit);

    }



        String firstNumber = lotteryNumberString.substring(0,0);
        String secondNumber = lotteryNumberString.substring(1,1);
        String thirdNumber = lotteryNumberString.substring(2,2);

        String firstTwoWinner = firstNumber + secondNumber;
        String lastTwoWinner = secondNumber + thirdNumber;
        String allNumbersWinner = firstNumber + secondNumber + thirdNumber;

        System.out.println("Please enter your three numbers (e.g. 123): ");

        String userInput = input.next();

         if(userInput.substring(0,2).equals(firstTwoWinner))

    {
        System.out.println("Winner: " + allNumbersWinner );

        System.out.println("Congratulations, the front pair matched.");
    }

    else if (userInput.substring(1,3).equals(lastTwoWinner))
    {
         System.out.println("Winner: " + allNumbersWinner );

         System.out.println("Congratulations, the end pair matched.");
    }

    else if (userInput.equals(allNumbersWinner))
    {
         System.out.println("Winner: " + allNumbersWinner );

         System.out.println("Congratulations, both pairs matched.");
    }

    else
    {
         System.out.println("Winner: " + allNumbersWinner );

         System.out.println("Sorry, no matches. You only had one chance out of 100 to win anyway.");
    }



}