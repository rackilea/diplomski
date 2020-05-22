public static void main(String[] args) {
    test(3, 3, 5); // max from question: 5
    test(5, 6, 5); // max from question: 7
    test(8, 5, 4); // max from question: 7
    test(5, 8, 4); // max from question: 7
    test(3, 5, 5);
    test(5, 3, 5);
    test(3, 7, 5);
    test(3, 7, 6);
    test(3, 7, 7);
    test(3, 7, 8);
    test(3, 7, 9);
}
static void test(int a, int b, int n) {
    System.out.printf("a = %d, b = %d, n = %d: The maximum value is %d. %s%n",
                      a, b, n, max(a, b, n), Arrays.toString(fill(a, b, n)));
}
static int[] fill(int a, int b, int n) {
    int[] v = new int[n];
    int i = 0, j = n - 1;
    v[i] = a;   v[j] = b;
    for (; v[i] < v[j]; i++)
        v[i + 1] = v[i] + 1;
    for (; v[i] > v[j]; j--)
        v[j - 1] = v[j] + 1;
    for (; i + 1 < j; i++, j--)
        v[i + 1] = v[j - 1] = v[i] + 1;
    return v;
}