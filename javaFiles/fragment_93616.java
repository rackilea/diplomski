public class AccessSorter
{ 
final static String letters = "< a, A < b, B < c, C < d, D < e, E < f, F < g, G < h, H < i, I < j, J < k, K < l, L < m, M < n, N < o, O < p, P < q, Q < r, R < s, S < t, T < u, U < v, V < w, W < x, X < y, Y < z, Z";
final static String digits = "< 0 < 1 < 2 < 3 < 4 < 5 < 6 < 7 < 8 < 9";
final static String special = "< '.' < '_'";
private RuleBasedCollator accessCollator;


AccessSorter()
{
    try
    {
        accessCollator = new RuleBasedCollator(special + digits + letters);
    }
    catch (ParseException e)
    {
        e.printStackTrace();
    }
}


SomeComparator getSomeComparator()
{
    return new SomeComparator();
}

class SomeComparator implements Comparator<String[]>
{
    @Override
    public int compare(String[] s1, String[] s2)
    {
       return accessCollator.compare(s1[1], s2[1]);
    }
}