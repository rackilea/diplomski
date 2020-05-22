static Object[][] convert(Collection<? extends Collection<?>> cc) {
    Object[][] res = new Object[cc.size()][]; 
    int i = 0;
    for (Collection<?> c : cc)
        res[i++] = c.toArray();
    return res;
}