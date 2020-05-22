public class Deck {
  // static final defines a constant valid for all the objects of that class.
  // this will allow us to initiase our array in a clean way.
  // You will notice that constants are always named with capital letters. 
  private static final String[] ORDERED_CARDS = new String[] {
      "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H",
      "9H", "10H", "JH"
      // etc.
    };

  // This is the member variable that holds the cards for our Deck objects
  private String[] cards;

  // The constructor allocates memory with the new keyword
  // Then it uses a function from the Java library to copy from one array to the other
  public Deck() {
    cards = new String[ORDERED_CARDS.length];
    System.arraycopy(ORDERED_CARDS, 0, cards, 0, ORDERED_CARDS.length);
  }

  // Using Google "java shuffle array" you'll find how to do it in one line using the 
  // Java library. There are other ways to do it, depending on which shuffle type 
  // you need. You could as well implement your own algorithm. The class to generate 
  // random numbers is called Random (part of the Java library)
  public void shuffle() {
    assert(cards!=null);
    Collections.shuffle(Arrays.asList(cards));
  }

  // The toString method shows how to iterate over an array or a collection using the 
  // "for-each" loop. We use a StringBuffer to build a string with the resulting card 
  // list. The final keyword says that this variable will not be re-allocated anywhere
  // else during this method. This avoids mistakes in long methods and also allows the
  // Java compiler to optimize your code
  public String toString() {
    final StringBuffer sb = new StringBuffer();
    for (String card : cards) {
      sb.append(card);
      sb.append(", ");
    }
    return sb.toString();
  }

  // The equals method shows how to iterate over an array or a collection using the 
  // "for" loop. 
  public boolean equals(Deck other) {
    if (other==null) return false;

    // assert is used to ensure that a Deck will always have cards. If not, the program 
    // will throw an Exception. This is good practise when you write classes to assert 
    // that you don't get values that should not be possible.
    assert(other.cards!=null);

    // Decks can only be equal if they have the same number of cards
    if (other.cards.length != this.cards.length) return false;

    final int cardCount = this.cards.length;
    for (int i=0; i<cardCount; ++i) {
      // Always compare strings using the equals method, not ==
      if (!this.cards[i].equals(other.cards[i])) return false;
    }

    // If we reach this point, then we have equal objects
    return true;
  }
}