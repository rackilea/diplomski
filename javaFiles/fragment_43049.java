public static void insertionSort(DeckOfCards cardsToSort) {
    final Comparator cardComparator = new CardComparator();
    for (int i = 0; i < cardsToSort.size() - 1; i++) {
        for (int k = i + 1; k > 0; k--) {
            final Card card1 = cardsToSort.getCards().get(k);
            final Card card2 = cardsToSort.getCards().get(k - 1);
            if(cardComparator.compare(card1, card2) < 0) {
                swap(cardsToSort, k, k-1);
            } else {
                break;
            }
        }
    }
}