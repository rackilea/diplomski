private <E> int indexOfItemClass(List<E> list, E item) {
    Class<? extends Object> itemClass = item.getClass();
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getClass().isAssignableFrom(itemClass)) {
            return i;
        }
    }
    return -1;
}