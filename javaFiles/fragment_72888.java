PrizeCard[] prizeCards; //populated in constructor

public void reset(){
    for(int i = 0; i < prizeCards.length; i++){
        swap(i, rand.nextInt(prizeCards.length)); //There are better shuffle algorithms for the record
    }
}

private void swap(int i, int j){
    PrizeCard temp = prizeCards[i];
    PrizeCard[i] = PrizeCard[j];
    PrizeCard[j] = temp;
}