public class Card {

    public static final char[][] TEMPLATE = {
        "┌─────┐".toCharArray(),
        "|?    |".toCharArray(),
        "|  *  |".toCharArray(),
        "|    ?|".toCharArray(),
        "└─────┘".toCharArray()
    }

    /*
     * Instance variable that stores the 
     * printable matrix for this card.
     */
    private char[][] printableMatrix;

    public Card(...) {
        ...
        this.printableMatrix = _cloneTemplate();
    }

    /*
     * Sets the value and suit of this card
     * in the matrix, and returns it
     */
    public char[][] getPrintableMatrix() {
        // Replace the * with actual suit and
        // ? with actual values
        printableMatrix[1][1] = this.getPrintableValue();
        printableMatrix[2][3] = this.getPrintableSuit();
        // ... and so on

        return printableMatrix;
    }

    /*
     * Creates a clone of the TEMPLATE. Each card object
     * is assigned a new copy of the template.
     */
    private static char[][] _cloneTemplate() {
        // Create a clone of the template.
        char[][] cardMatrix = new char[TEMPLATE.length][];

        for(int i = 0; i < TEMPLATE.length; i++) {
            cardMatrix[i] = new char[TEMPLATE[i].length];
            for(int j = 0; j < TEMPLATE[i].length; j++) {
                cardMatrix[i][j] = TEMPLATE[i][j];
            }
        }

        return cardMatrix;
    }

}