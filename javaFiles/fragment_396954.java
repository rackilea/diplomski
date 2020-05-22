public static void main(String[] args) {
    takeTurn(new Scanner(System.in)); // just an example how you share a single Scanner as a parameter when calling takeTurn function
}

public static void takeTurn(Scanner sc/*, Deck deck*/) { // static may be removed if you do not use the function within static main void
    if (isYResponse(sc, "Would you like another card? (Y or N) ")) {
        System.out.println("response is y");
        /*
        hand.getCards().add(deck.getTopCard());
        System.out.println("Current hand: " + hand);
        if (hand.getValue() > 21) {
            System.out.println("You busted with " + hand.getValue());
        }
        */
    } else {
        System.out.println("response is n");
    }
    takeTurn(sc/*, deck.next()*/); // be careful with this loop: define when it stops actually... when isGameOver(), for example?
}

private static boolean isYResponse(Scanner sc, String message) { // static may be removed if you do not use the function within static main void
    System.out.print(message);
    String response;
    if ((response = sc.nextLine()).isEmpty()) {
        response = sc.nextLine();
    }
    return ("y".compareToIgnoreCase(response) == 0)
            ? true
            : (("n".compareToIgnoreCase(response) == 0)
                ? false
                : isYResponse(sc, message));
}