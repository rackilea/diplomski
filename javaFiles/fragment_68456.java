public static void printOneInLine(char[] words, int len) {
    //for every word, print them in a line
    for (int i = 0 ; i < len ; i++){
        if (words[i] == ' ') // words separated by space creates a new line
            System.out.println();
        else
            System.out.print(words[i]); //print the character
    }
}