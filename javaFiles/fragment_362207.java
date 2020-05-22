public final class DoubleAndString
{
    private final String stringValue;
    private final double doubleValue;

    public DoubleAndString(String stringValue, double doubleValue)
    {
        this.stringValue = stringValue;
        this.doubleValue = doubleValue;
    }

    public String getString()
    {
        return stringValue;
    }

    public String getDouble()
    {
        return doubleValue;
    }
}