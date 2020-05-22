public <T extends Number> void mulBy2Attempt2(List<T> list) {
    for (int i = 0; i < list.size(); i++) {
        list.set(i, multiplyBy2(list.get(i)));
    }
}

private <T extends Number> T multiplyBy2(T num) {
    if (num instanceof BigDecimal) {
        return (T) ((BigDecimal) num).multiply(new BigDecimal(2));
    }
    if (num instanceof BigInteger) {
        return (T) ((BigInteger) num).multiply(new BigInteger("2"));
    }
    if (num instanceof Long) {
        return (T) new Long(num.longValue() * 2);
    }
    if (num instanceof Integer) {
        return (T) new Integer(num.intValue() * 2);
    }
    if ((num instanceof Double)) {
        return (T) new Double(num.doubleValue() * 2);
    }
    if (num instanceof Float) {
        return (T) new Float(num.floatValue() * 2);
    }
    if (num instanceof Byte) {
        return (T) new Byte((byte) (num.byteValue() * 2));
    }
    if (num == null) {
        throw new NullPointerException("Cannot multiply a null-number by two");
    }
    throw new IllegalArgumentException("Cannot handle a number of " + num.getClass().getCanonicalName() + " yet.");
}