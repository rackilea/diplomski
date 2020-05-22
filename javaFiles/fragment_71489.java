public static class EmptyKey implements SecretKey {
    private static final long serialVersionUID = 1L;

    @Override
    public String getAlgorithm() {
        return "HMAC";
    }

    @Override
    public String getFormat() {
        return "RAW";
    }

    @Override
    public byte[] getEncoded() {
        // return empty key data
        return new byte[0];
    }
}