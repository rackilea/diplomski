public void convertKeystore(Path sourceKeystorePath,
                            char[] sourceKeystorePassword,
                            Path destKeystorePath,
                            char[] destKeystorePassword)
throws GeneralSecurityException, IOException {

    KeyStore sourceKeystore = KeyStore.getInstance("jks");
    try (InputStream stream =
            new BufferedInputStream(
                Files.newInputStream(sourceKeystorePath))) {
        sourceKeystore.load(stream, sourceKeystorePassword);
    }

    KeyStore destKeystore = KeyStore.getInstance("pkcs12");
    destKeystore.load(null, destKeystorePassword);

    // Assume each alias in a keystore has the same password
    // as the keystore itself.
    KeyStore.ProtectionParameter sourceAliasPassword =
        new KeyStore.PasswordProtection(sourceKeystorePassword);
    KeyStore.ProtectionParameter destAliasPassword =
        new KeyStore.PasswordProtection(destKeystorePassword);

    Enumeration<String> aliasList = sourceKeystore.aliases();
    while (aliasList.hasMoreElements()) {
        String alias = aliasList.nextElement();
        KeyStore.Entry entry =
            sourceKeystore.getEntry(alias, sourceAliasPassword);
        destKeystore.setEntry(alias, entry, destAliasPassword);
    }

    try (OutputStream stream =
            new BufferedOutputStream(
                Files.newOutputStream(destKeystorePath))) {
        destKeystore.store(stream, destKeystorePassword);
    }
}