while (l < r) {
    int m = (l + r) / 2;

    if (A[m] == X) {
        return m;
    }
    if (A[m] > X) {
        r = m - 1;
    } 
    else if (A[m] < X) {
        l = m + 1;
    }
}
return -1;