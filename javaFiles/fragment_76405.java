public static int intersectionsCount(Set set1, Set set2) {
    if (set2.size() < set1.size()) return intersectionsCount(set2, set1);
    int count = 0;
    for (Object o : set1)
        if (set2.contains(o)) count++;
    return count;
}

public static double commonRatio(Set set1, Set set2) {
    int common = intersectionsCount(set1, set2);
    int union = set1.size() + set2.size() - common;
    return (double) common / union; // [0.0, 1.0]
}