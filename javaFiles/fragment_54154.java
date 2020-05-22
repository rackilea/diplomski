public static void main(String[] args) {
    int i = 5;
    int j = 0;
    for (int k = 1; k <= i; k++) {
        System.out.println("row count is " + j);
        j = increment(j); //  IT is important to store it in `j` again, otherwise j will still be 2 after the execution
        j += 1;
    }
}

private static int increment(int j) {
    if (j == 2) {
        j += 1;
        System.out.println("row count is " + j);
    }
    return j;
}