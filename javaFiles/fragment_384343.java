public static void main(String args[]) {
    int[] a = { 1, 7, 3, 2, 4, 1, 8, 14 , 9};
    int current = 0;
    for (int i = 0; i < 3; i++) {
        for (int j = current; j < a.length; j++) {
            if (a[j] % 4 == i) {
                int b = a[j];
                a[j] = a[current];
                a[current] = b;
                current++;
            }
        }
    }
    System.out.println(Arrays.toString(a));
}