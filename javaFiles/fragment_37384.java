public int[] findSameElements(int[] p1, int[] p2)
{
    int count = 0;
    bool[] choosen = new bool[p2.length];

    for (int i = 0; i < p1.length; i++)
    {
        for (int j = 0; j < p2.length; j++)
        {
            if (!choosen[j] && p1[i] == p2[j])
            {
                choosen[j] = true;
                count++;
                break;
            }
        }
    }

    int[] result = new int[count];
    count = 0;
    for (int i = 0; i < p2.length; i++)
    {
        if (choosen[i])
        {
            result[count] = p2[i];
            count++;
        }
    }

    return result;
}