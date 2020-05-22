public static void main(String[] args) throws Exception {
    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
    KeyPair keyPair = keyPairGen.genKeyPair();
    RSAPrivateCrtKey privKey = (RSAPrivateCrtKey) keyPair.getPrivate();

    BigInteger n = privKey.getModulus();
    BigInteger e = privKey.getPublicExponent();
    BigInteger d = privKey.getPrivateExponent();
    BigInteger p = privKey.getPrimeP();
    BigInteger q = privKey.getPrimeQ();
    BigInteger dp = privKey.getPrimeExponentP();
    BigInteger dq = privKey.getPrimeExponentQ();
    BigInteger inverseQ = privKey.getCrtCoefficient(); 

    StringBuilder builder = new StringBuilder();
    builder.append("<RSAKeyValue>\n");
    write(builder, "Modulus", n);
    write(builder, "Exponent", e);
    write(builder, "P", p);
    write(builder, "Q", q);
    write(builder, "DP", dp);
    write(builder, "DQ", dq);
    write(builder, "InverseQ", inverseQ);
    write(builder, "D", d);
    builder.append("</RSAKeyValue>");

    System.out.println(builder.toString());
}

private static void write(StringBuilder builder, String tag, BigInteger bigInt) {
    builder.append("\t<");
    builder.append(tag);
    builder.append(">");
    builder.append(encode(bigInt));
    builder.append("</");
    builder.append(tag);
    builder.append(">\n");
}

private static String encode(BigInteger bigInt) {
    return new String(Base64.encodeInteger(bigInt), "ASCII");
}