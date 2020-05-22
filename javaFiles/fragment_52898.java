int rem(int x, int y) {

    if (x == 0) {
        return 0;
    }

    int ret = rem(x - 1, y);

    if (ret + 1 == y) {
        return 0;
    }

    return ret + 1;
}