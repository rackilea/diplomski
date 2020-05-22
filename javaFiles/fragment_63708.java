public static void main(String[] args) {

    printWithSmileys("\\:D/");
    printWithSmileys("92.");

}

private static void printWithSmileys(String string) {
    // Find the length of our line in smiley 
    // (smiley length is 2 so we divide by 2 and add one to round up)
    int length = (string.length()+1)/2;
    // Add one smiley on each side, plus 2 smiley
    length += 2;
    // Add one smiley for the two spaces surrounding our string
    length += 1;
    // Add one space if length is an odd number
    if (string.length()%2 != 0)
        string += " ";

    //Print first line
    printSmileyLine(length);

    //Print middle line
    System.out.print(":) ");
    System.out.print(string);
    System.out.print(" :)");
    System.out.println("");

    //Print last line
    printSmileyLine(length);
}

/**
 * Print length smiley 
 */
private static void printSmileyLine(int length) {
    for (int i=0; i<length; i++)
        System.out.print(":)");
    System.out.println("");
}