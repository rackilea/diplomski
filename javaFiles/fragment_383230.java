public static Item fromEntry(Map.Entry<Integer, List<String>> entry) {
    return new Item(
        entry.getKey(),
        String.join(", ", entry.getValue().toArray(new String[0]))
    );
}