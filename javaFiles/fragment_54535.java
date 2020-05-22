public int getHand(Card c1, Card c2, Card c3) {

    if((c1 != null) && (c2 != null) && (c3 != null)){
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(c1);
        hand.add(c2);
        hand.add(c3);

        Collections.sort(hand, new SortCards());
    }else{
        #handle your null card situation here
        System.out.println("One or more card is null");
    }
}