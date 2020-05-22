public void processServerCertificate(Certificate serverCertificate) throws IOException
{
    SubjectPublicKeyInfo subPubKeyInfo = serverCertificate.certs[0].getTBSCertificate().getSubjectPublicKeyInfo();
    RSAPublicKey pubKey = RSAPublicKey.getInstance(subPubKeyInfo.getPublicKey());
    rsaServerPublicKey = new RSAKeyParameters(false,pubKey.getModulus(),pubKey.getPublicExponent());
}