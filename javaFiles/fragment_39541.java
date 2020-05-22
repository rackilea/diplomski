private static final int NUM_CARDS = 52;

public static void main(String[] args) {
  enumerateAllHands(Integer.parseInt(args[0]));
}

private static void enumerateAllHands(int n) {
  if (n > NUM_CARDS) {
    throw new IllegalArgumentException();
  }
  int[] cards = new int[n];
  BitSet cardsUsed = new BitSet();
  enumerate(cards, 0, cardsUsed);
}

private static void enumerate(int[] cards, int from, BitSet cardsUsed) {
  if (from == cards.length) {
    emit(cards);
  } else {
    for (int i = 0; i < NUM_CARDS; i++) {
      if (!cardsUsed.get(i)) {
        cards[from] = i;
        cardsUsed.set(i);
        enumerate(cards, from + 1, cardsUsed);
        cardsUsed.clear(i);
      }
    }
  }
}

private static void emit(int[] cards) {
  System.out.println(Arrays.toString(cards));
}