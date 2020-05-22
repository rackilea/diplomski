class Test {

    public static void asterisk(int m, int n) {
        if (m == n) {
            printAsterisk(m);
            return;
        } else if (m < n) {
            printAsterisk(m);
            asterisk(m + 1, n);
        } else {
            printAsterisk(m);
            asterisk(m - 1, n);
        }
    }

    public static void printAsterisk(int m) {
        for (int i = 0; i < m; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        asterisk(m, n);
        asterisk(n, m);
    }

}