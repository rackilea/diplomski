public final Random random = new Random();

public void shuffle() {
    for(int i = 0; i < 200; i++) {
        int firstCardIndex = random.nextInt(number - 1);
        int secondCardIndex = random.nextInt(number - 1);

        Card firstCard = deck[firstCardIndex];
        Card secondCard = deck[secondCardIndex];

        deck[firstCardIndex] = secondCard;
        deck[secondCardIndex] = firstCard;
    }
}