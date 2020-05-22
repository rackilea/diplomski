public class DeckRun {

    static Deck d1 = new Deck();

    public static void run() throws IOException {

        printDeck();
        System.out.println("");
        d1.dealCards();
        System.out.println("");
        menu();

    }

    public static void printDeck() {

        System.out.println(d1.toString());
    }


    public static void menu() throws IOException{

        BufferedReader readRacer = new BufferedReader(new InputStreamReader(System.in));

        int menu = 0;

        do {

        System.out.println("Press 1 to be dealt 5 random cards.");
        System.out.println("Press 2 to shuffle all the cards back into the deck.");
        System.out.println("Press 3 to quit the application.");

        String input = readRacer.readLine();
        menu = Integer.parseInt(input);

        switch (menu) {

        case 1: d1.dealCards();
        System.out.println("");
            break;
        case 2: System.out.println("The deck has been shuffled.");
                    d1.shuffleCards();
                    System.out.println("");
            break;
        case 3: System.out.println("I'm not bad, I'm just drawn that way.");
            break;
        }
        } while (menu != 3);
    }

}