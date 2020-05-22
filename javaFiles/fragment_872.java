/**
     * Deterministically generate a public and secret key.
     * Store the seed somewhere if you want to generate these
     * keys again.
     * @param publicKey Public key will be populated here of size {@link #PUBLICKEYBYTES}.
     * @param secretKey Secret key will be populated here of size {@link #SECRETKEYBYTES}.
     * @param seed A random seed of size {@link #SEEDBYTES}.
     * @return True if generated successfully.
     */
    boolean cryptoKxSeedKeypair(byte[] publicKey, byte[] secretKey, byte[] seed);