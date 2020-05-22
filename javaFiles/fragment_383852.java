public static KeyStore build(byte[] jksOrCerts, byte[] privateKey,
                             char[] jksPassword, char[] keyPassword)
    throws IOException, CertificateException, KeyStoreException,
    NoSuchAlgorithmException, InvalidKeyException,
    NoSuchProviderException, ProbablyBadPasswordException,
    UnrecoverableKeyException {

    ...
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(null, jksPassword);
        Iterator keysIt = keys.iterator();
        Iterator chainsIt = chains.iterator();
        int i = 1;
        while (keysIt.hasNext() && chainsIt.hasNext()) {
            Key key = (Key) keysIt.next();
            Certificate[] c = (Certificate[]) chainsIt.next();
            X509Certificate theOne = buildChain(key, c);
            String alias = "alias_" + i++;
            // The theOne is not null, then our chain was probably altered.
            // Need to trim out the newly introduced null entries at the end of
            // our chain.
            if (theOne != null) {
                c = Certificates.trimChain(c);
                alias = Certificates.getCN(theOne);
/* line 176 */  alias = alias.replace(' ', '_');
            }
            ks.setKeyEntry(alias, key, keyPassword, c);
        }
        return ks;
    }
}