BigInteger iter = BigInteger.valueOf(140);
BigInteger y = BigInteger.valueOf(1114112);
BigInteger sum = BigInteger.valueOf(0);
while(iter.intValue() != 0) {
    BigInteger z = y.pow(iter.intValue();
    sum = sum.add(z);
    iter = iter.subtract(BigInteger.valueOf(1));
    System.out.println("Itereration: " + (140 - iter.longValue()));
    System.out.println("Y: " + y);
    System.out.println("Z: " + z);
    System.out.println("Sum: " + sum);
}