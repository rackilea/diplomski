public class arr<T extends Comparable<T>>
{
    ArrayList<T> list;
    Comparator<T> comparator;
    public arr()
    {
        list = new ArrayList<T>();
        comparator = Comparator.naturalOrder();
    }
    // rest of code
}