public void start(String name) {
    if (name.equals("ABC")) {
        synchronized (this) {
            itemToStatus.put(name, true);
            items.add(name);
        }
    }
}

public synchronized boolean containsItem(String name) {
    return items.contains(name);
}

public synchronized boolean containsStatus(String name) {
    return itemToStatus.containsKey(name);
}