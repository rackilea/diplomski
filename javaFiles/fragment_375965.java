public static boolean checkWord(String a, String b)
{
    int j;
    for(int i = 0; i < a.length(); i++)
    {
        j = 0;
        while(j < b.length())
        {
            if(a.charAt(i) == b.charAt(j)) break;
            j++;
        }
        if(j == b.length()) return false;
    }
    return true;
}