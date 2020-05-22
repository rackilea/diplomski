public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("9349988899999");
        BigInteger bigInteger1 = bigInteger.subtract(new BigInteger("1"));
        System.out.println(randomBigInteger(bigInteger1));
    }

    public static BigInteger randomBigInteger(BigInteger n) {
        Random rnd = new Random();
        int maxNumBitLength = n.bitLength();
        BigInteger aRandomBigInt;
        do {
            aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
            // compare random number lessthan ginven number
        } while (aRandomBigInt.compareTo(n) > 0); 
        return aRandomBigInt;
    }