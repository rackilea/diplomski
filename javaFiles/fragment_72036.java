for (int row = 0; row < myEntries.size(); ++row)
{
    if ((mark12Line = mark12Br.readline()) != null)
    {
        for (int column = 0; column < myEntries.get(row).length; ++column)
        {
            if (!isInteger(myEntries.get(row)[column]))
            {
                mark12Map.put(mark12Line.split(",")[0], myEntries.get(row)[column]);
            }
        }
    }
    else
    {
        break;
    }
}