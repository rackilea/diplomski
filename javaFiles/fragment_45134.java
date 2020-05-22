@Override
public final BigInteger getPrivateExponent() {
    if (key.isEngineBased()) {
        throw new UnsupportedOperationException("private exponent cannot be extracted");
    }

    ensureReadParams();
    return privateExponent;
}