public static void main(String[] args) {
    // provide some sample data
    List<BigInteger> bigInts = new ArrayList<>();
    bigInts.add(new BigInteger("123456789101112"));
    bigInts.add(new BigInteger("123456789101113"));
    bigInts.add(new BigInteger("123456789101114"));
    bigInts.add(new BigInteger("123456789101115"));
    bigInts.add(new BigInteger("54"));

    // provide a variable for the expression
    int i = 51;
    // convert your expression to String
    BigInteger n = findIn(bigInts, String.valueOf(3 + i));

    System.out.println(n.toString());
}