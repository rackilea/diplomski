public void CreateDeck(){
    //Before
    //Card[] deck = new Card[52];

    //Correction
    deck = new Card[52];

    String[] suit = {"Spades", "Hearts", "Diamonds", "Clubs"};
    int[] number = {1,2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13};

    deck[0] = new Card("Spades",1);
    deck[1] = new Card("Spades",2);
    deck[2] = new Card("Spades",3);
    deck[3] = new Card("Spades",4);

    ...
}