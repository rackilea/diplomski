static boolean isPalindrome(String input)
{
    int i = 0;
    int last = input.length() - 1;
    int differentCount = 0;
    while (i < last) {
        if (input.charAt(i) != input.charAt(last)) {
            differentCount++;
            // only return false if more than one character is different
            if (differentCount > 1) {
                return false;
            }
        }
        i++;
        last--;
    }
    return true;
}