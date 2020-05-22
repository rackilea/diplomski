public static boolean checkWord() {
    String randomString = "BFEABLDEG";
    String word = "LABEL";
    for (int i = 0; i < word.length(); i++) {
        if (randomString.indexOf(word.charAt(i)) == -1) {
            return false;
        }
    }
    return true;
}