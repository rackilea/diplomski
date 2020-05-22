// get your 20% first
int chunk = nonRatedBooks.size() / 5;
List<List<Integer>> result = new LinkedList<List<Integer>>();
if (chunk < 1) {
    nonRatedBooks.stream().map(Lists::newArrayList).collect(Collectors.toCollection(() -> result));
} else {
    for (int i = 0; i < 5; i++) {
        int endIndex = i < 4 ? (i + 1) * chunk : nonRatedBooks.size();
        result.add(nonRatedBooks.subList(i * chunk, endIndex));
    }
}