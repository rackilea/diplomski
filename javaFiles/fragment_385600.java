int card = 0;
System.out.println("The deck contains the following: \n");
for(PlayingCard.CardSuit suit : PlayingCard.CardSuit.values()) {
    for(PlayingCard.CardRank rank : PlayingCard.CardRank.values()) {
        if(deck[ card++ ]) {
            System.out.println(rank + " of " + suit + "\n");
        }
     }
}