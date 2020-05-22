public static void main(String args[]) {
    System.out.print("#Enter word: ");
    String word = BIO.getString();

    while (!word.equals("END")) {
        char[] letters = word.toLowerCase().toCharArray();

        if (isItPalindrome(letters) == true) {
            System.out.println(word + "   is a palindrome");
        } else {
            System.out.print(word + "   is not a palindrome");
        } // OR
        // Use this one-liner instead of the if:
        // System.out.println(word + isItPalindrome(letters) ?
        //                     "   is a palindrome" : "   is not a palindrome");

    System.out.print("#Enter word: ");
    word = BIO.getString();
    }

}

public static boolean isItPalindrome(char letters[]) {
    for (int i = 0; i < letters.length / 2; i++) {
        if (letters[i] != letters[letters.length - i - 1]) {
            return false;
        }
    }

    return true;
}