public static boolean numericEquals(
    Collection<? extends Number> c1,
    Collection<? extends Number> c2
) {
    if(c1.size() != c2.size())
        return false;
    if(c1.isEmpty())
        return true;

    Iterator<? extends Number> it1 = c1.iterator();
    Iterator<? extends Number> it2 = c2.iterator();

    while(it1.hasNext()) {
        if(it1.next().doubleValue() != it2.next().doubleValue())
            return false;
    }

    return true;
}