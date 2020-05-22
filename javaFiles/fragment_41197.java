private void playGame() {
    //choose a word
    int random = rand.nextInt(words.size ());
    String newWord = words.get(random);
    words.remove(random);
    currWord = newWord;