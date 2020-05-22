private static int collatz(BigInteger n) {
    count++;
    if (n.compareTo(BigInteger.ONE) > 0) {
        if (!n.testBit(0)) // even
            return collatz(n.divide(BigInteger.valueOf(2)));

        else
            return collatz(n.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE));
    }
    return count - 1;
}

public static void main(String[] args) {
    System.out.println("res: " + collatz(BigInteger.valueOf(837799)));
}