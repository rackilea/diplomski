public class Main 
{
    final static int MAX_VALUE = 400;
    final static Long[] powers = new Long[MAX_VALUE + 1];

    public static void main(String args[])
    {
        final Long[] values = {1L, 1L, 1L, 1L, 1L};


        for (Integer i = 0; i <= MAX_VALUE; i++)
        {
            powers[i.intValue()] = Double.valueOf(Math.pow(i.doubleValue(), 4d)).longValue();
        }
        //new Main().trySolutionRecursivly(values);
        new Main().findSolution(values);
    }

    private void findSolution(final Long[] values)
    {
        Long[] newValues = values;
        while (conditionNotMet(newValues))
        {
            newValues = increaseValues(values);
        }
        System.out.println("a = " + values[0] + "; b = " + values[1] + "; c = " + values[2] + "; d = " + values[3] + "; e = " + values[4]);
    }

    private void trySolutionRecursivly(final Long[] values) 
    {
        System.out.println("a = " + values[0] + "; b = " + values[1] + "; c = " + values[2] + "; d = " + values[3] + "; e = " + values[4]);
        if (conditionMet(values))
        {
            System.out.println("Met the condition!");
        }
        else
        {
            Long[] newValues = increaseValues(values);
            trySolutionRecursivly(newValues);
        }   
    }

    private boolean conditionNotMet(final Long[] values)
    {
        return !conditionMet(values);
    }

    private boolean conditionMet(final Long[] values)
    {
        return pow(values[0]) + pow(values[1]) + pow(values[2]) + pow(values[3]) == pow(values[4]); 
    }

    private Long pow(final Long value)
    {
        return powers[value.intValue()];
        //return Math.pow(value.doubleValue(), 4d);
    }

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
}