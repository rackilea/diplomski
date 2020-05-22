public enum Suit {

    HEARTS(0), SPADES(-2), CLUBS(-1), DIAMONDS(1);

    private int value;

    private Suit(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}