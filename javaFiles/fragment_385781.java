Enumeration<String> aliases = keystore.aliases();
while (aliases.hasMoreElements()) {
    String alias = aliases.nextElement();
    if (store.entryInstanceOf(alias, KeyStore.TrustedCertificateEntry.class))
        certificates.put(alias, (X509Certificate) store.getCertificate(alias));
}