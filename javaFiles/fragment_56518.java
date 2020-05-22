static <T> List<T> computeIntersection(List<T> list0, List<T> list1)
{
    Set<T> set0 = new LinkedHashSet<T>(list0);
    Set<T> set1 = new LinkedHashSet<T>(list1);
    set0.retainAll(set1);
    return new ArrayList<T>(set0);
}