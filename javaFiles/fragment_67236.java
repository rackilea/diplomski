public List<Integer> extractIntegers(String input)
{
    List<Integer> result = new ArrayList<Integer>();
    int index = 0;
    int v = 0;
    int l = 0;
    while (index < input.length())
    {
        char c = input.charAt(index);
        if (Character.isDigit(c))
        {
            v *= 10;
            v += c - '0';
            l++;
        } else if (l > 0)
        {
            result.add(v);
            l = 0;
            v = 0;
        }
        index++;
    }
    if (l > 0)
    {
        result.add(v);
    }
    return result;
}