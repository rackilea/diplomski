Second implements Serializable, Comparable<Second> 
{
    First object;
    int temperature;

    @Override
    public int compareTo(Second other)
    {
        return compareByTime(this, other); // The method from above 
    }
}