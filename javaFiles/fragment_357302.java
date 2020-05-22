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