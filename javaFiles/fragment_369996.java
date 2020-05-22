import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RandomCard implements Comparator<RandomCard> {

    int num;
    int suitNum;
    String cardSuit = "";
    String cardNum = "";

    public RandomCard() {
        num = (int) (Math.random() * 13) + 2;
        suitNum = (int) (Math.random() * 4) + 1;

        if (num == 11) {
            cardNum = "Jack";
        } else if (num == 12) {
            cardNum = "Queen";
        } else if (num == 13) {
            cardNum = "King";
        } else if (num == 14) {
            cardNum = "Ace";
        } else {
            cardNum = "" + num;
        }

        if (suitNum == 1) {
            cardSuit = "Hearts";
        } else if (suitNum == 2) {
            cardSuit = "Spades";
        } else if (suitNum == 3) {
            cardSuit = "Clubs";
        } else {
            cardSuit = "Diamonds";
        }
    }

    public int getNum() {
        return num;
    }

    public int getSuitNum() {
        return suitNum;
    }

    public String getCardSuit() {
        return cardSuit;
    }

    public String getCardNum() {
        return cardNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        RandomCard randomCard = (RandomCard) obj;
        return this.getNum() == randomCard.getNum() && this.getSuitNum() == randomCard.getSuitNum();
    }

    @Override
    public String toString() {
        return cardNum + " of " + cardSuit;
    }

    @Override
    public int compare(RandomCard o1, RandomCard o2) {
        int c = new Integer(o1.getNum()).compareTo(o2.getNum());
        if (c == 0) {
            c = new Integer(o1.getSuitNum()).compareTo(o2.getSuitNum());
        }
        return c;
    }

    public static class RandomCardDeck {

        ArrayList<RandomCard> deck;
        String order = "";

        public RandomCardDeck() {
            deck = new ArrayList<>();
            checkDeck(new RandomCard(), 0);
            //your deck is now full with 52 cards
        }

        public ArrayList<RandomCard> getDeck() {
            return deck;
        }

        private void checkDeck(RandomCard card, int i) {
            if (deck.size() == 52) {
                return;
            }
            if (i >= deck.size()) {
                deck.add(card);
                checkDeck(new RandomCard(), 0);
            } else if (card.equals(deck.get(i))) {
                checkDeck(new RandomCard(), 0);
            } else {
                checkDeck(card, ++i);
            }
        }

        @Override
        public String toString() {
            for (int i = 0; i <= deck.size(); i++) {
                order += deck.get(i);
            }
            return order;

        }
    }

    public static void main(String[] args) {
        RandomCardDeck cardDeck = new RandomCardDeck();
        Collections.sort(cardDeck.getDeck(), new RandomCard());
        for (RandomCard randomCard : cardDeck.getDeck()) {
            System.out.println(randomCard);
        }
    }
}