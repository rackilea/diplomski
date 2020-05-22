private static ArrayList<String> hearts;
private static ArrayList<String> diamonds;
private static ArrayList<String> clubs;
private static ArrayList<String> spades;
private static int cardsLeft = 52;

static {
    hearts = new ArrayList<String>();
    diamonds = new ArrayList<String>();
    clubs = new ArrayList<String>();
    spades = new ArrayList<String>();

    for(int i = 0; i <= 10; i++) {
        hearts.add(Integer.toString(i));
    }
    hearts.add("jack");
    hearts.add("queen");
    hearts.add("king");
    hearts.add("ace");

    diamonds.addAll(hearts);
    clubs.addAll(hearts);
    spades.addAll(hearts);

}

// will shuffle your list
public static void main(String[] args) {

    for(int j = 0; j <=10 ; j++) {
        Collections.shuffle(hearts);  // this will do the magic

        System.out.println("List shuffled: ");      
        for(String i : hearts) 
            System.out.println(i + " ");  
    }

}