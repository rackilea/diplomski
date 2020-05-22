class AbstractA<T,U> {
    Map<String, Map<T, BigInteger>> counts = new HashMap<String, Map<T,BigInteger>>();
    Map<String, Map<BigDecimal, U>> sums = new HashMap<String, Map<BigDecimal, U>>();
 }
 class AbstractB<T> extends AbstractA<T, Set<T>> {
 }
 class D extends AbstractB<BigInteger> {
 }
 class R extends AbstractB<String> {
 }
 class S extends AbstractA<BigInteger, BigInteger> {
 }