private final List<A> allKnownValues = ...;

List<A> getAllValuesOfTheSameType(A sample) {
    ArrayList<A> results = new ArrayList<>();
    for (A candidate : allKnownValues) {
        if (candidate.getClass() == sample.getClass()) {
            results.add(candidate);
        }
    }
    return results;
}