public static int countGroups(int[] a) {
    if (a.length < 2) return a.length;
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < a.length; i++) {
        if (a[i] >= a[i - 1]) stack.push(i);
        for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
            swap(a, j, j - 1);
            if (j <= stack.peek()) stack.pop();
        }
    }
    return stack.size();
}

private static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
}