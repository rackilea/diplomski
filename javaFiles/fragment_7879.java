int f(int min, int max, int x) {
    const int len = (max - min) * 2;
    const int offset = (x + len - 1) % len;
    const int ans = (offset + 1) % len;
    return min + ans > max ? min + len - ans : min + ans;
}