int compare(MenuItem a, MenuItem b) {
    return comparePosition(toPositions(a), toPositions(b));
}

int comparePosition(List<Integer> a, List<Integer> b) {
    if (a.isEmpty() && b.isEmpty()) {
        return 0;
    } else if (a.isEmpty()) {
        return 1;
    } else if (b.isEmpty()) {
        return -1;
    } else  {
        int aFirst = a.removeFirst();
        int bFirst = b.removeFirst();
        if (aFirst != bFirst) {
            return aFrist-bFirst;
        } else {
            return comparePosition(a, b);  // compare remaining list
        }
    }
}