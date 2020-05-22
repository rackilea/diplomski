List<Set<String>> list = new ArrayList<>();

Comparator<Set<String>> comparator = new Comparator<Set<String>>() {
    @Override
    public int compare(Set<String> o1, Set<String> o2) {
        // TODO: Implement your logic to compare the sets
    }
};

SortedMap<Set<String>, Integer> set = new TreeMap<>(comparator);

// TODO: Fill the set