Collections.sort(s, new LengthCompare());
for (int i = s.size() - 1; i >= 1; i--)
{
    for (int j = i-1; j >= 0; j--)
    {
        if (s[j].contains(s[i]))
        {
            s.remove(i)
            break;
        }
    }
}

private static class LengthCompare implements Comparator<String>
{
    public int compare(String s1, String s2)
    {
        return (s2.length() - s1.length());
    }
}