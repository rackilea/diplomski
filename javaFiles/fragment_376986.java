private static PublicKey readPublicKey(String path) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
    PEMParser pemParser = new PEMParser(new FileReader(path));
    Object object = pemParser.readObject();
    SubjectPublicKeyInfo subjectPublicKeyInfo = (SubjectPublicKeyInfo) object;

    RSAKeyParameters rsa = (RSAKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);

    RSAPublicKeySpec rsaSpec = new RSAPublicKeySpec(rsa.getModulus(), rsa.getExponent());
    KeyFactory kf = KeyFactory.getInstance("RSA", new BouncyCastleProvider());
    return kf.generatePublic(rsaSpec);
}