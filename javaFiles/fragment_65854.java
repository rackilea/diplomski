for (int i = 0; i < end; i++) {
    both[i] = first[i];
}
for (int i = 0; i < end2; i++) {
    both[i + end] = second[i];
}

// simple sorting algorithm
for (int d = both.length - 1; d >= 0; d--) {
    for (int i = 0; i < d; i++) {
        if (both[i] > both[d]) {
            int t = both[d];
            both[d] = both[i];
            both[i] = t;
        }
    }
}