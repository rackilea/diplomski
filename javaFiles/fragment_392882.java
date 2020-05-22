class Exercise13r {
    public static void main(String[] args) {
        recursion(12);
    }

    public static void recursion(long n) {
        System.out.println ("number: " + n);
        if (n != 1) {
            if (n % 2 == 0) {
                recursion(n/2);
            } else {
                recursion(n*3-1);
            }
        }
    }
}