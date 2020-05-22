boolean isLetterOrDigit(String s) {
    final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    final String NUMBERS = "1234567890";
    final String ALLOWED = UPPERCASE_LETTERS 
    + LOWERCASE_LETTERS + NUMBERS;
    for (char ch : s.toCharArray()) {
        if (ALLOWED.indexOf(ch) == -1) {
            return false;
        }
    } 
    return true;
}