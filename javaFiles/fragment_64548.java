public class Suit {
    private final String name;

    public static final Suit CLUBS =new Suit("clubs");
    public static final Suit DIAMONDS =new Suit("diamonds");
    public static final Suit HEARTS =new Suit("hearts");
    public static final Suit SPADES =new Suit("spades");    

    private Suit(String name){
        this.name =name;
    }
    public String toString(){
        return name;
    }

}