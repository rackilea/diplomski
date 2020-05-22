BigInteger end = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.valueOf(10));
// Display results
for (BigInteger i = BigInteger.valueOf(Long.MAX_VALUE); i.compareTo(end) <= 0; 
            i = i.add(BigInteger.ONE)) {
    System.out.println(i.multiply(i));
}