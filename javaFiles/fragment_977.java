public static String middleWord(String word1, String word2, String word3) {

    for (int i = 0; (i < word1.length() || i < word2.length() || i < word3.length()); i++) {
        char ch1 = 10000;
        char ch2 = 10000;
        char ch3 = 10000;
        if(word1.length() > i){
            ch1 = word1.charAt(i);
        }
        if(word2.length() > i){
            ch2 = word2.charAt(i);
        }
        if(word3.length() > i){
            ch3 = word3.charAt(i);
        }
        if (ch1 <= ch2 && ch2 <= ch3) {
            return word2;
        } else if (ch2 <= ch1 && ch1 <= ch3) {
            return word1;
        } else if (ch1 <= ch3 && ch3 <= ch2) {
            return word3;
        }

    }
    return null;
}