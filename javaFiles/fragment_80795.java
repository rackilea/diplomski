public void fill() {
    for (int i = 0; i<52;i++){ // get rid of this loop
    for (Suit s : Suit.values()) {
    for (Rank r : Rank.values()) {
        cards[i]= new Card(r,s);
}