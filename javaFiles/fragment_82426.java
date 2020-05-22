import Tracker.NewDeckOrder;
 import Tracker.OutFaro;
 import java.util.Scanner;

public class Main {


public static void main(String[] args) {
    int cardAfterOneShuffle = 0;

    Scanner input = new Scanner(System.in);

    // Bicycle new deck order
    System.out.println("Current deck order:");
    NewDeckOrder newDeckOrder = new NewDeckOrder();
    newDeckOrder.setBicycleDeckOrder(newDeckOrder.americanNewDeckOrder());
    System.out.println(newDeckOrder.getBicycleDeckOrder().toString());

    // User input
    System.out.println("\nPlease enter the card you wish to track: ");
    String cardToTrack = input.nextLine();

    System.out.println("\nHow many out Faro's would you like to shuffle?");
    int numberOfFaros = input.nextInt();


    int cardsPosition = 0;

    if (newDeckOrder.americanNewDeckOrder().contains(cardToTrack)) {
        cardsPosition += newDeckOrder.americanNewDeckOrder().indexOf(cardToTrack) + 1;
    }
    System.out.println("\n" + cardToTrack + " starting position is " + cardsPosition + ".");

    OutFaro outFaro = new OutFaro();

    outFaro.outFaro(newDeckOrder.getBicycleDeckOrder(), numberOfFaros);

    System.out.println("\n" + "After " + numberOfFaros + " shuffles the deck order is: " + outFaro.getOneShuffle());


    if (outFaro.getOneShuffle().contains(cardToTrack)) {
        cardAfterOneShuffle += outFaro.getOneShuffle().indexOf(cardToTrack) + 1;

    }

    System.out.println("\n" + "After " + numberOfFaros + " shuffles your card is at number " + cardAfterOneShuffle);


}


}