public enum RANK {

    TWO(2), THREE(3), ACE(14);

    private int value;

    private Suit(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}