public class CardSet {

        // Create ENUM for both Suites and Ranks
        public enum Ranks {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE, CLOWN}
        public enum Suits {SPADES, HEARTS, CLUBS, DIAMONDS, CLOWN}

        private final Ranks rank;
        private final Suits suit;
        private int numOfDecks;

        public CardSet(Suits suit, Ranks rank) {
            this.rank = rank;
            this.suit = suit;
        }

        private static final List<CardSet> deck  = new ArrayList<CardSet>();

        static {
            for (Suits suit : Suits.values()) {
                for (Ranks rank : Ranks.values()) {
                    if ((suit != Suits.CLOWN && rank != Ranks.CLOWN) || (suit == Suits.CLOWN && rank == Ranks.CLOWN)) {
                        deck.add(new CardSet(suit, rank));
                    }
                }
            }
        }
        public int getNumOfDecks(){
            return this.numOfDecks;
        }

        public List<CardSet> getNewDeck(){
            return new ArrayList<>(deck);
        }