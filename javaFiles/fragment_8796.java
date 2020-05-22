public ArrayList<String> singlePhrase(char c, ArrayList<String> wordList) {
    ArrayList<String> words = new ArrayList<String>();
    for (int i = 0; i < wordList.size(); i++) {
        if (Character.toLowerCase(wordList.get(i).charAt(0)) == Character.toLowerCase(c)) {
            words.add(wordList.get(i));
        }
    }
    return words;
}