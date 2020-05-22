public int countAxA(String str, char c1, char c2) {

 int count = 0;
    for (int i=0; i < str.length(); i++)
    {
        if (str.charAt(i) == c1)
        {
             if(i+2 < str.length() && str.charAt(i+2) == c2)
                count++;
        }
    }
    return count;
}