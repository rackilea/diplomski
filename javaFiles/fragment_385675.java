public static String expand(String word) {
    if (word.length() <= 1) {
        return word; //Return Original word
    } else {
        return word.substring(word.length() - 1) + "-" + expand(word.substring(0, word.length() - 1));
    }
}