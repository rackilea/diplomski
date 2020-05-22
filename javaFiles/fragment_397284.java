public int addWithFactorsRecursive(int[] a, int i, int n) {
    if (i < 0) // Exceptional case where 
        return -1;
    else if (i == n - 1) // End recursion here 
        return (i + 1) * a[i];
    else if (i < n - 1) // Return the term, and consider further terms
        return (i + 1) * a[i] + addWithFactorsRecursive(a, i + 1, n);
    return 0;
}