static boolean isWordPalindrome(String input) {
    // My code
    if (input == null || input.length() == 0 || input.length() == 1) return true;
    String reverseWordInput = reverseWords(input);
    boolean isPalindrome = input.equals(reverseWordInput);
    return isPalindrome;
}