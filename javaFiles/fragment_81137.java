int[] elements = { 1, 1, 2, 3, 3, 4 };
Set<Integer> singleSet = new HashSet<>();
Set<Integer> repeatedSet = new HashSet<>();

for (int e : elements) {
    if (repeatedSet.contains(e)) {
        continue;
    }
    if (singleSet.contains(e)) {
        singleSet.remove(e);
        repeatedSet.add(e);
    } else {
        singleSet.add(e);
    }
}

for (int e : elements) {
    if (singleSet.contains(e)) {
        return e;
    }
}