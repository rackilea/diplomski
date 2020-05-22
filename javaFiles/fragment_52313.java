public void repeat(StringBuilder result, String str, int n) {
    if (n == 0) return;
    result.append(str);
    repeat(result, str, n - 1);
    return;
}