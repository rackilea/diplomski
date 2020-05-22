String line = in.nextString();
 BigDecimal decimal = new BigDecimal(line);
 try {
     section._internal.put(name, decimal.intValueExact());
 } catch (ArithmeticException e) {
     try {
         section._internal.put(name, decimal.longValueExact());
     } catch (ArithmeticException ex) {
         section._internal.put(name, decimal.doubleValue());
     }
}