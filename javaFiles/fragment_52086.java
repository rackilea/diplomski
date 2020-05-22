String modulusElem = "...";
String dElem = "...";

byte[] modulusBytes = Base64.decode(modulusElem, Base64.DEFAULT);
byte[] dBytes = Base64.decode(dElem, Base64.DEFAULT);

BigInteger modulus = new BigInteger(1, modulusBytes);
BigInteger d = new BigInteger(1, dBytes);

String data = "my data";            

try {
        Signature signature = Signature.getInstance("SHA1withRSA");

        KeyFactory factory = KeyFactory.getInstance("RSA");

        RSAPrivateKeySpec privateKeySpec = new RSAPrivateKeySpec(modulus, d);

        PrivateKey privateKey = factory.generatePrivate(privateKeySpec);

        signature.initSign(privateKey);

        signature.update(data.getBytes("UTF-8"));

        byte[] SignedByteData = signature.sign();

} catch(Exception e) {
    e.printStackTrace();
}