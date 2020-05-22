public int compareTo(Foo other)
{
    if (other == null)
    {
        throw new NullPointerException();
    }
    if (year < other.year)
    {
        return -1;
    }
    if (year > other.year)
    {
        return 1;
    }
    if (month < other.month)
    {
        return -1;
    }
    if (month > other.month)
    {
        return 1;
    }
    // etc
    // If we haven't returned after comparing everything
    // then the values must be equal
    return 0;
}