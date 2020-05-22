private static int distance(String s1, String s2, int i, int j) {
    if (j == s2.length()) {
        return s1.length() - i;
    }
    if (i == s1.length()) {
        return s2.length() - j;
    }
    if (s1.charAt(i) == s2.charAt(j))
        return distance(s1, s2, i + 1, j + 1);
    int rep = distance(s1, s2, i + 1, j + 1) + 2; // since Jim Belushi considers replacement to be worth 2.
    int del = distance(s1, s2, i, j + 1) + 1;
    int ins = distance(s1, s2, i + 1, j) + 1;
    return Math.min(del, Math.min(ins, rep));
}