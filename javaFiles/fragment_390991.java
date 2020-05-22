List<Pair> deck = new ArrayList<Pair>();

List<String> suits = new ArrayList<String>();
suits.add("Hearts");
suits.add("Diamonds");
suits.add("Clubs");
suits.add("Spades");

List<String> faces = new ArrayList<String>();
faces.add("Ace");
faces.add("King");
faces.add("Queen");
faces.add("Jack");

for(int suit = 0; suit < suits.size(); suit++){

    for(int face = 0; face < faces.size(); face++){

        deck.add(new Pair(suits.get(suit), faces.get(face)));             

    }

}