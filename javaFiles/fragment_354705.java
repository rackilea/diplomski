public class JavaApplication8 {

    public static String[] possCards = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public static String[] possSuits = new String[]{"C", "S", "H", "D"};
    public static Random rand = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (1<2){
            System.out.println(card());
        }
    }

    public static String card() {
        String suit = possSuits[rand.nextInt(possSuits.length)];
        String card = possCards[rand.nextInt(possCards.length)];

        return suit + card;
    }
}