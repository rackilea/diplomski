public static boolean palindrome(String s)
{
    if (s.length() < 2)
        return true;
    if (s.charAt(0) != s.charAt(s.length()-1))
        return false;
    return palindrome(s.substring(1,s.length()-1));
}