public class DoubleKey
{
    final double arg1, arg2, arg3;
    final int hashCode;

    public DoubleKey(double arg1, double arg2, double arg3)
    {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        hashCode = Objects.hash(arg1, arg2, arg3);
    }

    @Override
    public boolean equals(Object key)
    {
        if (key instanceof DoubleKey) {
            DoubleKey dk = (DoubleKey) key;
            return arg1 == dk.arg1 && arg2 == dk.arg2 && arg3 == dk.arg3;
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return hashCode;
    }
}