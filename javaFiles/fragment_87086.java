int iter = 140;
BigInteger y = BigInteger.valueOf(1114112);
BigInteger sum = BigInteger.valueOf(0);
while(iter != 0) {
    BigInteger z = y.pow(iter);
    sum = sum.add(z);
    iter--;
    System.out.println("Itereration: " + (140 - iter));
    System.out.println("Y: " + y);
    System.out.println("Z: " + z);
    System.out.println("Sum: " + sum);
}