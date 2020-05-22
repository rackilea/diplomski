from(source)
    .process(exchange -> decryptIfEncrypted(pgpEncryptionDetails))
to(destination);

ProcessDefinition decryptIfEncrypted(PGPEncryptionDetails pgpEncryptionDetails) {
    if (isPgpEncryped()) {
        PGPDataFormat pgpDataFormat = new PGPDataFormat();
        pgpDataFormat.setKeyFileName(pgpEncryptionDetails.getPrivateKeyPath());
        pgpDataFormat.setPassword(pgpEncryptionDetails.getPassphrase());
        pgpDataFormat.setKeyUserid(pgpEncryptionDetails.getUserId());
        return new ProcessDefinition().unmarshal(pgpDataFormat);
    }
    return new ProcessDefinition();
}