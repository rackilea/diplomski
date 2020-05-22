/** METHOD - getWordFromComputer*/
public static String getWordFromComputer(char[] let) {
    Random rand = new Random();
    rand.setSeed(System.currentTimeMillis());
    String word = "";
    boolean done = false;
    while(!done) {
        word = "";
        boolean[] used = new boolean[7];
        int lettersUsedCount = 0;

        //Generate random word length
        int max = 7;

        //RANGE 1 - Base of minimum
        int randomizedMinBase = ThreadLocalRandom.current().nextInt(3, 6 + 1);

        //RANGE 2 - Randomized minimum from Range 1 value to number 6.
        int randomizedMin2 = ThreadLocalRandom.current().nextInt(
                randomizedMinBase, 6 + 1);

        //RANGE 3 - Randomized minimum from Range 2 value to number 6
        int randomizedMin3 = ThreadLocalRandom.current().nextInt(
                randomizedMin2, 6 + 1);

        //FINAL RANGE - Range from randomizedMin3 to 7
        int mainMin = randomizedMin3;
        int size = ThreadLocalRandom.current().nextInt(mainMin, max + 1);

        while(lettersUsedCount < size) {
            int index = rand.nextInt(7); //Random from 0 to 6 (7)
            if(!used[index]) {//The current index hasn't been chosen yet
                used[index] = true;
                lettersUsedCount++;
                if(let[index] != '-') {//Use a regular tile
                    word += let[index]; 
                } else {//Update a blank tile
                    char randLetter = gameTiles[rand.nextInt(26)];
                    computerScore -= valueOfLetter(randLetter);
                    word += gameTiles[rand.nextInt(26)];
                }//End else
            }//End boolean if
        }//End while

        /* Verify if a word to ensure the computer always generates a
         * playable word
         */
        if(wordVerify(word)) {
            done = true;
        }//End if
    }//End boolean while
    return word;
}//End getWordFromComputer method