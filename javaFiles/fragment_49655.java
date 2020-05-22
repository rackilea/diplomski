for (int j = 0; j < n; ++j)
{
    for (int m = 0; m < 1; m++)
    {
                // Here is the problem
        list[j][m] = new LinkedList<Charater>();
        list[j][m].add("" + (characterArray[j]));
    }
}