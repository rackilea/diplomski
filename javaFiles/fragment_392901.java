public int[] remove(int[] arr) {
    // Array of max length
    int p[] = new int[arr.length];
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
        if (!isMultipleOf3(arr[i]) && !containsDigit3(arr[i])) {
            p[count] = arr[i];
            ++count;
        }
    }
    // Array of right length - System.arraycopy not allowed?!
    int[] q = new int[count];
    for (int i = 0; i < q.length; ++i) {
        q[i] = p[i];
    }
    return q;
}