public class TwoFieldComparator implements Comparator<Foo>
{
    public int compare(Foo first, Foo second)
    {
        // TODO: null checks
        int firstComparison = Integer.compare(first.x, second.x);
        return firstComparison != 0 ? firstComparison
                                    : Integer.compare(first.y, second.y);
    }
}