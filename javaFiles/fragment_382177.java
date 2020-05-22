public boolean isAlphanumeric(String str)
{
    char[] charArray = str.toCharArray();
    for(char c:charArray)
    {
        if (!Character.isLetterOrDigit(c))
            return false;
    }
    return true;
}