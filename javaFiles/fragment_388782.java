public static void correct() {

    score++;
    System.out.println("You are right! your score is: " + score);
    System.out.println(Deck.getCards().size() + " total cards");
    currentCard = Deck.getNextCard();  
    System.out.println("your current card is " + currentCard.getName());

}