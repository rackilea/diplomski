private static int insertRec(int[] a, int e, int l, int r) {
    int mid = l + (r - l) / 2;
    if (l == r) return l;
    else if (a[mid] < e) return insertRec(a, e, mid+1, r);
    else return insertRec(a, e, l, mid);
}