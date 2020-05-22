public static synchronized boolean removeInstance(BeanTest toRemove) {
    if (list.contains(toRemove)) {
        return list.remove(toRemove);
    }
    return false;
}