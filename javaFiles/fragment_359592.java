public void mergeQs(ArrayQmerge q) {
    Object[] array = new Object[this.size() + q.size()];

    int i;
    int o;

    // Interleave elements
    for (i = 0, o = 0; i < this.size() && i < q.size(); ++i) {
        array[o++] = this.array[i];
        array[o++] = q.array[i];
    }

    // Copy the remaining elements
    while (i < this.size()) {
        array[o++] = this.array[i++];
    }

    while (i < q.size()) {
        array[o++] = q.array[i++];
    }

    this.array = array;
}