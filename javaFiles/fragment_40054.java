public class C extends B
{
    @Override
    public int hashCode ()
    {
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals (Object other)
    {
        return this == other;
    }
}