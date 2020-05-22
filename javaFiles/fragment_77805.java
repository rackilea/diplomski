public class PlayingCard {
    // private members...

    // some method
    public void someMethod() {
        Vector<String> possibleSuits = new Vector<String>(4);

        // This loop must be executed in a code block
        for(String currentSuit:suits){
            possibleSuits.add(currentSuit);
        }
        // Do more stuff
    }
}