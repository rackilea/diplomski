public class FirstClass 
{
    private List<SecondClass> list = new ArrayList<>();

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof FirstClass))
            return false;
        FirstClass fc = (FirstClass) other;
        return list.equals(fc.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode ();
    } 
}