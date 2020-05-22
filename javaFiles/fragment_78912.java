public class War {

    public static void main(String[] args) {
        String[] deckcards=deck();
        // shuffle deck
        List<String> list = new ArrayList<>(Arrays.asList(deckcards));
        Collections.shuffle(list);
        deckcards = list.toArray(new String[]{});
        // deal from deck
        String[] player1cards=player1Cards(deckcards, 0, 5);
    }
    public static String[] deck(){
        String[] Cards = {"spades1","spades2","spades3", "spades4", "spades5", "spades6", "spades7", "spades8", "spades9", "spades10", "spadesJ", "spadesQ", "spadesK", "spadesA", "clubs1", "clubs2", "clubs3", "clubs4", "clubs5", "clubs6", "clubs7", "clubs8", "clubs9", "clubs10", "clubsJ", "clubsQ", "clubsK", "clubsA", };
        return Cards;
    }
    public static String [] player1Cards(String[] deckcards, int from, int quantity){
        String[] player1cards = Arrays.copyOfRange(deckcards, from, from + quantity);
        return player1cards;
    }
}