import java.math.BigInteger;

public class MyBigInt extends BigInteger {

    private BigInteger delegate;

    public MyBigInt() {
        super("0");
    }

    private BigInteger getDelegate() {
        if (delegate == null) {
            delegate = computeMeHere();
        }
        return delegate;
    }

    public byte byteValue() {
        return getDelegate().byteValue();
    }

    public short shortValue() {
        return getDelegate().shortValue();
    }

    public BigInteger nextProbablePrime() {
        return getDelegate().nextProbablePrime();
    }

    public BigInteger add(BigInteger val) {
        return getDelegate().add(val);
    }

    public BigInteger subtract(BigInteger val) {
        return getDelegate().subtract(val);
    }

    public BigInteger multiply(BigInteger val) {
        return getDelegate().multiply(val);
    }

    public BigInteger divide(BigInteger val) {
        return getDelegate().divide(val);
    }

    public BigInteger[] divideAndRemainder(BigInteger val) {
        return getDelegate().divideAndRemainder(val);
    }

    public BigInteger remainder(BigInteger val) {
        return getDelegate().remainder(val);
    }

    public BigInteger pow(int exponent) {
        return getDelegate().pow(exponent);
    }

    public BigInteger gcd(BigInteger val) {
        return getDelegate().gcd(val);
    }

    public BigInteger abs() {
        return getDelegate().abs();
    }

    public BigInteger negate() {
        return getDelegate().negate();
    }

    public int signum() {
        return getDelegate().signum();
    }

    public BigInteger mod(BigInteger m) {
        return getDelegate().mod(m);
    }

    public BigInteger modPow(BigInteger exponent, BigInteger m) {
        return getDelegate().modPow(exponent, m);
    }

    public BigInteger modInverse(BigInteger m) {
        return getDelegate().modInverse(m);
    }

    public BigInteger shiftLeft(int n) {
        return getDelegate().shiftLeft(n);
    }

    public BigInteger shiftRight(int n) {
        return getDelegate().shiftRight(n);
    }

    public BigInteger and(BigInteger val) {
        return getDelegate().and(val);
    }

    public BigInteger or(BigInteger val) {
        return getDelegate().or(val);
    }

    public BigInteger xor(BigInteger val) {
        return getDelegate().xor(val);
    }

    public BigInteger not() {
        return getDelegate().not();
    }

    public BigInteger andNot(BigInteger val) {
        return getDelegate().andNot(val);
    }

    public boolean testBit(int n) {
        return getDelegate().testBit(n);
    }

    public BigInteger setBit(int n) {
        return getDelegate().setBit(n);
    }

    public BigInteger clearBit(int n) {
        return getDelegate().clearBit(n);
    }

    public BigInteger flipBit(int n) {
        return getDelegate().flipBit(n);
    }

    public int getLowestSetBit() {
        return getDelegate().getLowestSetBit();
    }

    public int bitLength() {
        return getDelegate().bitLength();
    }

    public int bitCount() {
        return getDelegate().bitCount();
    }

    public boolean isProbablePrime(int certainty) {
        return getDelegate().isProbablePrime(certainty);
    }

    public int compareTo(BigInteger val) {
        return getDelegate().compareTo(val);
    }

    public boolean equals(Object x) {
        return getDelegate().equals(x);
    }

    public BigInteger min(BigInteger val) {
        return getDelegate().min(val);
    }

    public BigInteger max(BigInteger val) {
        return getDelegate().max(val);
    }

    public int hashCode() {
        return getDelegate().hashCode();
    }

    public String toString(int radix) {
        return getDelegate().toString(radix);
    }

    public String toString() {
        return getDelegate().toString();
    }

    public byte[] toByteArray() {
        return getDelegate().toByteArray();
    }

    public int intValue() {
        return getDelegate().intValue();
    }

    public long longValue() {
        return getDelegate().longValue();
    }

    public float floatValue() {
        return getDelegate().floatValue();
    }

    public double doubleValue() {
        return getDelegate().doubleValue();
    }

    public long longValueExact() {
        return getDelegate().longValueExact();
    }

    public int intValueExact() {
        return getDelegate().intValueExact();
    }

    public short shortValueExact() {
        return getDelegate().shortValueExact();
    }

    public byte byteValueExact() {
        return getDelegate().byteValueExact();
    }
}