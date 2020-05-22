public String reverseWord(String word) {
    for( int i = 0; i < word.length(); i++) {
        stk.push(word.charAt(i));
    }
    return stk.empty();
}