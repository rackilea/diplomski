class MyHashMap extends LinkedHashMap<String, String> {
    LinkedList<String> lowPriorityItems = new LinkedList<>();

    @Override
    void addEntry(int hash, String key, String value, int bucketIndex) {
        if (isLowValue(key)) {
            lowPriorityItems.add(key);
        }
        if (size >= threshold) {
            if (lowPriorityItems.isEmpty()) {
                super.addEntry(hash, key, value, bucketIndex);
            else {
                removeAll(lowPriorityItems);
                lowPriorityItems.clear();
                super.createEntry(hash, key, value, bucketIndex);
            }
        }
    }
}