Card[] a = deque.toArray(new Card[0]);
Arrays.sort(a);
deque.clear();
for (Card card : a) {
    deque.add(card);
}