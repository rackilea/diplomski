public static <T> Pair<T, Integer> mode(T items[]) {
    // If the array is empty, return a dummy pair object
    if (items.length == 0) {
        return new Pair(null, 0);
    }

    // Create a map to store the elements count
    Map<T, Integer> countFromItem = new HashMap<>();
    // For each item in the array
    for (T item : items) {
        // Get the current count
        Integer count = countFromItem.get(item);
        // If there is no current count
        if (count == null) {
            // Set the count to 0
            count = 0;
        }
        // Add 1 to the item current count
        countFromItem.put(item, count + 1);
    }

    // After we found correct count for each element
    T mode =  null;
    int maxCount = 0;
    // Go through each entry (element: count) in the map
    for (Map.Entry<T, Integer> entry : countFromItem.entrySet()) {
        // If the this entry count is greater than the greatest count until now
        if (entry.getValue() > maxCount) {
            // This entry element is the mode
            mode = entry.getKey();
            // This entry count is the maxCount
            maxCount = entry.getValue();
        }
    }
    return new Pair(mode, maxCount);
}