static <T extends List<Integer>> T add2 (T lst) {
    T res;
    try {
        res = (T) lst.getClass().newInstance();

    } catch (InstantiationException e) {
        throw new IllegalArgumentException(e);
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    }

    for (Integer i : lst) res.add(i + 2);
    return res;
}