while (left < right) {
    int mid = (left + right) >>> 1;
    if (pivot.compareTo(a[mid]) < 0) // <--- here is the compareTo call
        right = mid;
    else
        left = mid + 1;
}
assert left == right;