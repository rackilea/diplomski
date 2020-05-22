public static String wordPyramid(String word) {
    int length = word.length();
    System.out.println(word);   //printing word
    if (word.length() == 1) {
        return word;
    } else {

        return word = wordPyramid(word.substring(1, length - 1));
    }

}