public boolean findWord(String word, String[] table) {
    for(int i = 0; i < table.length; i++) {
        if (table[i].equals(word)) {
            //this line is necessary because otherwise your loop
            //will continue setting found to false if there are
            //any other words in the array
            return true;
        }
    }
    return false;
}