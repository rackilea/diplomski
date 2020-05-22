TreeMap<String, Object> treeMap = someEntries();
    Iterator<Entry<String, Object>> iter = treeMap.entrySet().iterator();
    Entry<String, Object> entry;
    while (iter.hasNext()) {
        entry = iter.next();
        if (!entry.getKey().contains(search)) {
            iter.remove();
        }
    }