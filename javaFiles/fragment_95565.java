static void solve(Box A, Box B, Box C, Box D, Box[][] likes, int n) {
    if (n > 11) {
        System.out.printf("A=%s B=%s C=%s D=%s%n", A, B, C, D);
        return;
    }
    for (Box box : likes[n]) {
        if (!box.add(n)) continue;
        solve(A, B, C, D, likes, n + 1);
        box.remove(n);
    }
}