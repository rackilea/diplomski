while (aCount != var_a.length() && b.Count != var_b.length()) {
    ... // merge
}
while (aCount != var_a.length()) {
    var_c[cCount++] = var_a[aCount++];
}
while (bCount != var_b.length()) {
    var_c[cCount++] = var_b[bCount++];
}