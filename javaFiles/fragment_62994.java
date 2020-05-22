List<Map.Entry<String, UserMetrics>> sortedEntries = new ArrayList<>(map.entrySet());
Collections.sort(sortedEntries,
    Map.Entry.comparingByValue(
        Comparator
            .comparingLong(UserMetrics::getParam1)
            .thenComparingLong(UserMetrics::getParam2)));