try {
....
KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) this.keyStore.getEntry("alias", null);
....
} catch (final Exception e) {
    e.printStackTrace();
    if (e instanceof InvalidKeyException) { // bypass InvalidKeyException
        .......
        // You can again call the method and make a counter for deadlock situation or implement your own code according to your situation
        if (retry) {
            keyStore.deleteEntry(keyName);
            return getCypher(keyName, false);
        } else {
            throw e;
        }
    }
}