private void findSolution()
{
    Long[] newValues = {1L, 1L, 1L, 1L, 1L};
    while (conditionNotMet(newValues))
    {
        newValues = increaseValues(values);
    }
    System.out.println("a = " + values[0] + "; b = " + values[1] + "; c = " + values[2] + "; d = " + values[3] + "; e = " + values[4]);
}