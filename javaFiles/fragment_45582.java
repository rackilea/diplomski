static boolean isWordPalindrome(String input) {
    // My code
    String reverseWordInput = reverseWords(input);
    boolean isPalindrome = input.equals(reverseWordInput);
    return isPalindrome;
}