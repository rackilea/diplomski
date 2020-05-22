BinaryOperator<Set<Species>> speciesReducer = (set1, set2) -> {
    Set<Species> newSet = new HashSet<>();

    newSet.addAll(set1);
    newSet.addAll(set2);

    return newSet;
};