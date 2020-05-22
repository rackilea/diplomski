public static ArrayList<String> theDeck() {
// save shuffled deck in an arraylist
   ArrayList<String> theDeck = new ArrayList<String>();
   for (int i = 0; i < n; i++) {
      theDeck.add(deckArray[i]);
   }
   return theDeck;
}