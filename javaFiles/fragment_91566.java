File pemFile = new File("test.pem");
try (PEMParser pp = new PEMParser(new InputStreamReader(new FileInputStream(pemFile)))) {
    SubjectPublicKeyInfo subjPubKeyInfo = (SubjectPublicKeyInfo) pp.readObject();
    RSAKeyParameters rsa = (RSAKeyParameters) PublicKeyFactory.createKey(subjPubKeyInfo);

    RSAPublicKeySpec rsaSpec = new RSAPublicKeySpec(rsa.getModulus(), rsa.getExponent());
    KeyFactory kf = KeyFactory.getInstance("RSA");
    java.security.PublicKey publicKey = kf.generatePublic(rsaSpec);
    System.out.println(publicKey);
}