private int hash;

...

public int hashCode() {
    int h = hash;
    if (h == 0 && count > 0) {
        int off = offset;
        char val[] = value;
        int len = count;

        for (int i = 0; i < len; i++) {
            h = 31*h + val[off++];
        }
        hash = h;
    }
    return h;
}