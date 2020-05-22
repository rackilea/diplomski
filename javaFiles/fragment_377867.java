private int compareNumbers(Number n1, Number n2)
    {
        BigDecimal n2c = new BigDecimal(n2.toString());
        BigDecimal n1c = new BigDecimal(n1.toString());

        return n1c.compareTo(n2c);
    }