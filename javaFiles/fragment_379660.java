// Personally I'd make the class final, but that's a different matter
public class BigNumber {
    private final BigInteger value; // Renamed from sum - see below

    public BigNumber(BigInteger value) {
        this.value = value;
    }

    public BigNumber(String value) {
        this(new BigInteger(value));
    }

    ... methods ...
}