// could go with the Pair idea from another post, but I personally don't like that way
class Line
{
    // would use appropriate names
    private final int intVal;
    private final String stringVal;

    public Line(final int iVal, final String sVal)
    {
        intVal    = iVal;
        stringVal = sVal;
    }

    public int getIntVal()
    {
        return (intVal);
    }

    public String getStringVal()
    {
        return (stringVal);
    }

    // equals/hashCode/etc... as appropriate
}