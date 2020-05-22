boolean contains (int [] x, int y) {
    for (int i : x) {
       if (i == y) return true;
    }

    return false;
}