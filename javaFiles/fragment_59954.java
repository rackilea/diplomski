Predicate<Entry<String, Integer>> predicate = new Predicate<Entry<String, Integer>>() {
    public boolean test(Entry<String, Integer> entry) {
        return entry.getKey() == null || entry.getKey().length() > 6;
    }
};
// ...
someMap.entrySet().stream().filter(predicate)