@NonNull
    public static AndroidKeyStorePublicKey loadAndroidKeyStorePublicKeyFromKeystore(
            @NonNull KeyStore keyStore, @NonNull String privateKeyAlias)
            throws UnrecoverableKeyException {
        KeyCharacteristics keyCharacteristics = new KeyCharacteristics();
        int errorCode = keyStore.getKeyCharacteristics(privateKeyAlias, null,
                null, keyCharacteristics);
        if (errorCode != KeyStore.NO_ERROR) {
            throw (UnrecoverableKeyException) new UnrecoverableKeyException(
                    "Failed to obtain information about private key")
                    .initCause(KeyStore.getKeyStoreException(errorCode)); // this exception is generated
        }
        ......
        ......
        ......
    }