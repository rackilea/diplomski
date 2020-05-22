private int stringMatcherCode (String word)
{
    int total = 0;
    for (int i = 0; i < word.length() && i < 6; i ++)
    {
        char ch = word.charAt (i);
        if (ch == '-') ch = (char)28;  // does not contain the same last 5 bits as any letter
        if (ch == '\'') ch = (char)29; // nor this
        total = (total * 33) + (ch & 0x1F);
    }
    return total;
}