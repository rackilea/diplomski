public String getEntry(String alias) {

    String secretStr = null;
    byte[] secret = null;

    if (mKeystore != null) {



        try {
            if (!mKeystore.containsAlias(alias)) {
                Log.w(TAG, new StringBuilder().append("Keystore ").append(mKeyStoreName)
                        .append(" does not contain entry ").append(alias).toString());
                return null;
            }
        } catch (KeyStoreException ex) {
            Log.e(TAG, "Failed to read keystore entry " + alias);
        }

        // get my entry from the key store
        KeyStore.ProtectionParameter pp = new KeyStore.PasswordProtection(null);
        KeyStore.SecretKeyEntry ske = null;
        try {
            ske = (KeyStore.SecretKeyEntry) mKeystore.getEntry(alias, pp);
        } catch (Exception ex) {
            Log.e(TAG, "Failed to read keystore entry " + alias);
        }

        if (ske != null) {
            SecretKeySpec sks = (SecretKeySpec) ske.getSecretKey();
            secret = sks.getEncoded();

            if (secret != null) {
                secretStr = new String(secret);


            } else {
                Log.e(TAG, new StringBuilder().append("Read empty keystore entry ").append(alias).toString());
            }
        } else {
            Log.e(TAG, "Failed to read keystore entry " + alias);
        }
    }
    return secretStr;
}