public class CardNames {
    public final static String[] SUITS = {
        "Spades", "Hearts", "Diamonds", "Clubs"
    };
    public final static String[] LEVELS = {
        "ace", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "jack", "queen", "king"
    };
    public final static String SEP = "";
    public final static String XTN = ".gif";

    public static void main(String[] args) {
        for (String suit : SUITS) {
            for (String level : LEVELS) {
                System.out.println(level + SEP + suit + XTN);
            }
        }
    }
}