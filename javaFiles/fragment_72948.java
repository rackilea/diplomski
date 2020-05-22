public int[] primesum(int A) {

    int[] arr = new int[A + 1];
    for (int i = 0; i <= A; i++) {
        // All the numbers are prime
        arr[i] = 1;
    }
    arr[0] = 0;//
    arr[1] = 0;
    for (int i = 2; i <= Math.sqrt(A); i++) {
        if (arr[i] == 1)
            for (int j = 2; i * j <= A; j++) {
                arr[i * j] = 0;
            }
    }

    for (int i = 0; i <= Math.sqrt(A); i++) {
        if (arr[i] == 1) {
            boolean b = checkprime((A - i));
            if (b) {
                arr = new int[2];
                arr[0] = i;
                arr[1] = A - i;
                break;
            }
        }
    }

    return arr;

}

private static boolean checkprime(int p) {
    boolean k = true;

    if (p == 1)
        return false;

    for (int i = 2; i <= Math.sqrt(p); i++) {
        if (p % i == 0)
            k = false;

    }
    return k;
}