Set<String> keys = table.keySet();
for (String count : keys) {
    if (table.containsKey(count)) {
        table.put(count, table.get(count) + 1);
    } else {
        table.put(count, 1);
    }
}