public class Main {
    public static String[] card; // The holder for all cards

    public static void main(String[] args) {
        card = generateCardSuits(); // generate the cards with their corresponding suits
        doPartOne();
        doPartTwo();
    }

    /**
     * Part One
     *
     */
    public static void doPartOne() {
        System.out.println("========== PART ONE ==========");
        int[] deck = generateAndShuffleInitialDeck();
        int ctr = 1;
        while (true) {
            if (deck[0] % 13 == deck[1] % 13 && deck[1] % 13 == deck[2] % 13 && deck[2] % 13 == deck[3] % 13) {
                break;
            }
            deck = shuffle(deck);
            ctr++;
        }
        System.out.println("Four-of-kind cards are: " + card[deck[0]] + " , " + card[deck[1]] + " , " + card[deck[2]]
                + " and " + card[deck[3]]);
        System.out.println("Number of shuffled times: " + ctr);
        System.out.println("==============================");
    }

    /**
     * Part Two
     *
     */
    public static void doPartTwo() {
        System.out.println("========== PART TWO ==========");
        int[][] deck = new int[2][52];
        deck[0] = generateAndShuffleInitialDeck();
        deck[1] = generateAndShuffleInitialDeck();

        int ctr = 1;
        while (deck[0][0] != deck[1][0] || deck[0][1] != deck[1][1]) {
            deck[0] = shuffle(deck[0]);
            deck[1] = shuffle(deck[1]);
            ctr++;
        }

        System.out.println("Two exact match cards from deck 1 are: " + card[deck[0][0]] + " and " + card[deck[0][1]]);
        System.out.println("Number of shuffled times: " + ctr);
        System.out.println("==============================");
    }

    /**
     * Generate an initial deck of cards and shuffle them
     *
     * @return The initial and shuffled deck of cards
     */
    public static int[] generateAndShuffleInitialDeck() {
        int[] deck = new int[52];

        for (int j = 0; j < deck.length; j++) {
            deck[j] = j;
        }
        return shuffle(deck);
    }

    /**
     * Generate the cards with their corresponding suits
     *
     * @return The deck that will serve as the mapper for the cards to their suits
     */
    public static String[] generateCardSuits() {
        String[] rank = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
        String[] suit = { "Spades", "Hearts", "Diamond", "Clubs" };

        String[] cards = new String[52];

        for (int i = 0, j = 0, s = 0; i < cards.length; i++) {
            cards[i] = rank[j] + " of " + suit[s];
            j++;
            if (j == 13) { // Since each suit consist of 13 cards
                j = 0;
                s++;
            }
        }
        return cards;
    }

    /**
     * Shuffle the deck of cards
     *
     * @param deck
     *            the deck of cards to be shuffle
     *
     * @return The shuffled deck of cards
     */
    public static int[] shuffle(int[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int index = (int) (Math.random() * deck.length);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
        return deck;
    }
}