public HashSet<String> getWordSet(){
    HashSet<String> set = new HashSet<String>();
    for (String words : quoteOne){
        words.add(word);
    }
    return words;
}