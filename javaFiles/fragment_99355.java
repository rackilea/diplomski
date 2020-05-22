public static void main(String[] args) {
        Function<Number, Double> bigToDouble = value -> {
            BigDecimal bigDec = null;
            if (value instanceof BigInteger) {
                BigInteger bigInt = (BigInteger) value;
                bigDec = new BigDecimal(bigInt);
            }
            if (value instanceof BigDecimal) {
                bigDec = (BigDecimal) value;
            }
            return bigDec.doubleValue();
        };

        BigDecimal bigDec = new BigDecimal("2.5");      
        BigInteger bigInt = new BigInteger("150000");
        System.out.println("FUNCTION TEST = " + bigToDouble.apply(bigInt));
        System.out.println("FUNCTION TEST = " + bigToDouble.apply(bigDec));
    }