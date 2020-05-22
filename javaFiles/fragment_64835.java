import java.util.Scanner;

public class CondoPriceSelector {

    public static void main(String[] args) {
        PriceSelector selector = new PriceSelector();
        try(Scanner scan = new Scanner(System.in)){
            int priceSelection = scan.nextInt();
            selector.printPrice(priceSelection);
        }
    }
}

class PriceSelector {
    final int parkingCost = 5000;

    public void printPrice(int selection) {
        switch (selection) {
            case (1):
                System.out.println("With a parking spot, the cost is $" + parkingCost);
                break;
            case (2):
                System.out.println("With a garage, the cost is $" + (parkingCost + 5000));  
                break;

            default:
                System.out.println("You have entered an invalid response; the condo will cost $" + parkingCost + ".");
        }
    }
}