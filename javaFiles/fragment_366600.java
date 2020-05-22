public final class MyEntry
{
    private final String parentName;
    private final String name;
    private final int hashCode;

    public MyEntry(final String parentName, final String name)
    {
        this.parentName = parentName;
        this.name = name;
        hashCode = 31 * parentName.hashCode() + name.hashCode();
    }

    // Override .equals() and .hashCode()
    @Override
    public int hashCode()
    {
        return hashCode;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        final MyEntry other = (MyEntry) o;
        return parentName.equals(other.parentName)
            && name.equals(other.name);
    }

    // Have a nice string representation
    @Override
    public String toString()
    {
        return "parent name: " + parentName + ", name: " + name;
    }
}