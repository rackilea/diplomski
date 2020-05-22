public static boolean compareCollection(Collection<Object> c1, Collection<Object> c2)   {
    if (c1 == null)
        return c2 == null;
    else if (c2 == null || c1.size() != c2.size())
        return false;
    Iterator<Object> it1 = c1.iterator();
    Iterator<Object> it2 = c2.iterator();
    while (it1.hasNext()) {
        Object o1 = it1.next();
        Object o2 = it2.next();
        if (!o1.equals(o2))
            return false;
    }
     return true;
}