public interface Key<T> extends Serializable {
    T getKeyValue();
}

public abstract class AbstractKey<T> implements Key<T> {

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof AbstractKey) {
            return getKeyValue().equals(((AbstractKey) obj).getKeyValue());
        }
        return false;
    }
}

public class StringKey extends AbstractKey<String> {

    private String keyValue;

    StringKey() {
        super();
    }

    protected StringKey(String val) {
        super(val);
        this.keyValue = val;
    }

    @Override
    public String getKeyValue() {
        return keyValue;
    }
}

public class BigIntKey extends AbstractKey<BigInteger> {

    private BigInteger keyValue;

    BigIntKey() {
        super();
    }

    protected BigIntKey(BigInteger val) {
        super(val);
        this.keyValue = val;
    }

    @Override
    public BigInteger getKeyValue() {
        return keyValue;
    }
}

...

public class KeyFactory {
    public static Key<String> getKey(String obj) {
        return new StringKey(obj);
    }

    public static Key<BigInteger> getKey(BigInteger obj) {
        return new BigIntKey(obj);
    }
}