public static boolean isVowel(char ch) {
    String str = Character.toString(ch);

    if ("AaEeIiOoUu".contains(str)) {
        return true;
    } else {
        return false;
    }
}