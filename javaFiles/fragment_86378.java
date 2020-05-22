for (int i = 1; i <= height; i++) {

    int n = height;
    int n2 = height + 1;
    for (int j = 1; j <= n - i; j++) {
        System.out.print("" + String.format("%3s", " ") + " ");
    }
    for (int k = i; k >= 1; k--) {
        System.out.print("" + String.format("%3s", k) + " ");
    }
    for (int l = 2; l <= i; l++) {
        System.out.print("" + String.format("%3s", l) + " ");
    }
    System.out.println();
    System.out.println();
}