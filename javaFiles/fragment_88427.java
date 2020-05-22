public static TreeSet<String> intersection(TreeSet<String> setA, TreeSet<String> setB) {
    // An optimization to iterate over the smaller set
    if (setA.size() > setB.size()) {
        return intersection(setB, setA);
    }
    TreeSet<String> results = new TreeSet<>();
    for (String element : setA) {
        if (setB.contains(element)) {
            results.add(element);
        }
    }
    return results;
}