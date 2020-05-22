private int countValleys(String s)
{
    int level = 0; // 0 is sea-level
    int valleys = 0;

    for (char c : s.toCharArray())
    {
        if (c == 'U') {
            level++;
            if (level == 0)
            {
                valleys++;
            }
        }
        else {
            level--;
        }
    }
    return valleys;
}