X509Certificate yourCert = ...
X509Certificate root = ...

try {
    yourCert.verify(root.getPublicKey()); } 
catch (CertificateException | NoSuchAlgorithmException | InvalidKeyException | NoSuchProviderException e) {
    //handle wrong algos
} catch (SignatureException ex) {
    //signature validation error
}