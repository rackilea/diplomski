// I assume you actually want a different upper bound?
for (int k = 0; k < keyword.length(); ++k)
{
    char c = keyword.charAt(k % keyword.length());
    if (c >= 'a' && c <= 'z')
    {
        key[k] = c - 'a';
    }
}