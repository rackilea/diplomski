public void removeAll(Object o) {
    int i = 0;
    while (i < length) {
        if (o.equals(items[i])) {
            removeItem(i);
        } else {
            i++;
        }
    }
}