public static void main(String[] args) {

    int a[] = { 1, 5, 100, 40, 80, 50 };

    int length = a.length;
    int temp;

    for (int i = 0; i < length; i++) {
        for (int j = 1; j < length - i; j++) {
            if (a[j - 1] > a[j]) {
                temp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = temp;
            }
        }
    }

    for (int i = 0; i < a.length; i++) {
        System.out.print(a[i] + " ");
    }
}