public static <T> Set<T> combineSets(Set<T> set1, Set<T> set2)
{
    return Collections.unmodifiableSet(new HashSet<T>() {{
        addAll(set1);
        addAll(set2);
    }});
}