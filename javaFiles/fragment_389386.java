public boolean isPalindrome(String string)
{
    if (string.length() > 2) {
        if (string.charAt(0) == string.charAt(string.length() - 1)) {
            return this.isPalindrome(string.substring(1, string.length() - 1));
        } else {
            return false;
        }
    } else if (string.length() == 1) {
        return true;
    } else {
        if (string.charAt(0) == string.charAt(1)) {
            return true;
        } else {
            return false;
        }
    }
}