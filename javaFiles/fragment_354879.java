import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        IntegerCount intCount = new IntegerCount();

        // number of integers to count in the range of 0 to 100
        int numberOfIntegersToCount = input.nextInt();

        System.out.println("Type Integers: ");

        // loop until all integers are read
        while (numberOfIntegersToCount > 0){
            int submit = input.nextInt();
            intCount.account(submit); //Should be where the integers are being sent to the IntegerCount class
            numberOfIntegersToCount--;
        }
        intCount.print();

    }
}