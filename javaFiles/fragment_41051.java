public static boolean isListOfSameElements(List<? extends Object> l) {
    Set<Object> set = new HashSet<Object>(l.size());
    for (Object o : l) {
        if (set.isEmpty()) {
            set.add(o);
        } else {
            if (set.add(o)) {
                return false;
            }
        }
    }
    return true;
}