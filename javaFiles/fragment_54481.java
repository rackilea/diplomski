int i = 0;
for (int x: initialList) {
    if (i < pivot) {
        left.add(x);
    }
    else {
        right.add(x);
    }
    i++;
}