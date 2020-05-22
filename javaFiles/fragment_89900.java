Set<Integer> bSet = new HashSet<Integer>();
for (int n : B) {
    bSet.add(n);
}
for (int n : A) {
    if (bSet.contains(n)) {
        return n;
    }
}
// If you get here, arrays have no elements in common