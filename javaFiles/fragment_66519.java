for (Row row : table) {
    if (count.containsKey(row)) {
        count.put(row, count.get(row) + 1);
    } else {
        count.put(row, 1);
    }
}