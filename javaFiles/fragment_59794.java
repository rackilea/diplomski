public static boolean palindrome(String text)
{
    for (int index = 0; index < text.length() / 2; index++) {
        if (text.charAt(index) != text.charAt(text.length() - index - 1)) {
            return false;
        }
    }
    return true;
}