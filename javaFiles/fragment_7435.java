class SecondComparator implements Comparator<Second>
{
    @Override
    public int compare(Second s0, Second s1)
    {
        return compareByTime(s0, s1); // The method from above 
    }
}