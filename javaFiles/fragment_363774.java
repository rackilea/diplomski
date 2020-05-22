public boolean setEntry(String alias, String secretKey) {

    boolean keyStoreEntryWritten = false;

    if (mKeystore != null && secretKey != null) {
        // store something in the key store
        SecretKeySpec sks = new SecretKeySpec(secretKey.getBytes(), "MD5");
        KeyStore.SecretKeyEntry ske = new KeyStore.SecretKeyEntry(sks);
        KeyStore.ProtectionParameter pp = new KeyStore.PasswordProtection(null);

        try {
            mKeystore.setEntry(alias, ske, pp);

            // save key store
            boolean success = saveKeyStore();

            if (success) {
                keyStoreEntryWritten = true;
            }
        } catch (KeyStoreException ex) {
            Log.e(TAG, "Failed to read keystore" + mKeyStoreName);
        }
    }
    return keyStoreEntryWritten;
}


private boolean saveKeyStore() {

    FileOutputStream fos = null;
    boolean keyStoreSaved = true;

    // generate key store path
    String keyStoreFilePath = generateKeyStoreFilePath(mKeyStoreName, mKeystoreDirectoryPath);


    try {
        fos = new FileOutputStream(keyStoreFilePath);
        mKeystore.store(fos, mKeyStorePassword.toCharArray());
    } catch (Exception ex) {
        keyStoreSaved = false;
        Log.e(TAG, "Failed to save keystore " + mKeyStoreName);
    } finally {
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException ex) {
                keyStoreSaved = false;
                Log.e(TAG, "Failed to close FileOutputStream");
            }
        }
    }
    return keyStoreSaved;
}