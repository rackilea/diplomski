int[] key = new int[1000]; // Or whatever
for (int k = 0; k < key.length; ++k)
{
    char c = keyword.charAt(k % keyword.length());
    if (c >= 'a' && c <= 'z')
    {
        key[k] = c - 'a';
    }
}