class VeryLong {
    Vector<Integer> A = new Vector<Integer>();

    VeryLong(int n) {
        while (n > 0) {
            A.add(0, n % 10);
            n /= 10;
        }
    }