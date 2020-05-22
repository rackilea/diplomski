for (int i: initialList) {
    if (i < pivot) {
        left.add(i);
    }
    else {
        right.add(i);
    }
}