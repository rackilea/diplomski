public static <T> Set<T> combineSets(Set<T> set1, Set<T> set2)
{
    HashSet<T> set = new HashSet<>(set1);
    set.addAll (set2);
    return Collections.unmodifiableSet(set);
}