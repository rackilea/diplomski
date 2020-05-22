class Prime {
    boolean esPrime(int n) {
        boolean prime = true;
        int divisor = 2;
        while (prime && divisor != n) {
            if (n % divisor == 0) {
                prime = false;
            }
            else {
                divisor++;
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        Prime p = new Prime();
        for(int i=2; i<10; ++i) {
            System.out.println("esPrime(" + i + ") = " + p.esPrime(i));
        }
    }
}