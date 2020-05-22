private Long[] increaseValues(final Long[] values) 
{
    boolean reindexed = false;
    for (int i = 0; i < values.length; i++)
    {
        if (values[i] == MAX_VALUE)
        {
            if (i > 0)
            {
                values[i-1]++;
                reindex(i, values);
                reindexed = true;
                break;
            }
            else
            {
                throw new IllegalStateException("No solution found.");
            }
        }
    }
    if (!reindexed)
    {
        values[values.length-1]++;
    }
    return values;
}

private Long[] reindex(final Integer startIndex, final Long[] values)
{
    Long startingValue = values[startIndex - 1];
    for (int i = startIndex; i < values.length; i++)
    {
        values[i] = startingValue;
    }
    return values;
}