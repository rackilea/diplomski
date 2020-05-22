public boolean removeItem(int position) {

    if(position >= items.size() || position < 0)
        return false;

    Product key = items.keySet().stream()
        .skip(position)
        .findFirst()
        .get();

    items.remove(key);
    return true;
}