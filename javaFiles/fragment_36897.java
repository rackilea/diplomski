public int hashCode() {
    int h = hash;  // the cached hash value
    int len = count;  // the number of characters in the string
    if (h == 0 && len > 0) {
        int off = offset;
        char val[] = value;

        for (int i = 0; i < len; i++) {
            h = 31*h + val[off++];
        }
        hash = h;
    }
    return h;
}