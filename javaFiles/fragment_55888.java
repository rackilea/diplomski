String key = "30820278020...1608"; // omitted for brevity

byte[] keyData = DatatypeConverter.parseHexBinary(key);
KeyFactory factory = KeyFactory.getInstance("RSA");
RSAPrivateKey privateKey = (RSAPrivateKey) factory
    .generatePrivate(new PKCS8EncodedKeySpec(keyData));

Signature signature = Signature.getInstance("SHA512withRSA");
signature.initSign(privateKey);
signature.update("Hello, World".getBytes());
System.out.println(DatatypeConverter.printHexBinary(signature.sign()));