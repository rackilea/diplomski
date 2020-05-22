public static boolean testPalindrome(String word)
{
    if(word.charAt(0)==word.charAt(word.length()-1))
    {
        if(word.length()==1)
        {
            return true;
        }
        word = word.substring(1, (word.length()-1));
        return testPalindrome(word);
    }
    return false;
}