// Generate Keys
ECGenParameterSpec ecGenSpec = new ECGenParameterSpec("secp256r1");
KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA", "BC");
keyPairGenerator.initialize(ecGenSpec, new SecureRandom());
java.security.KeyPair pair = keyPairGenerator.generateKeyPair();
ECPrivateKey privateKey = (ECPrivateKey) pair.getPrivate();
ECPublicKey publicKeyExpected = (ECPublicKey) pair.getPublic();

// Expected public key
System.out.print("Expected Public Key: " +
        BaseEncoding.base64Url().encode(publicKeyExpected.getEncoded()));

// Generate public key from private key
KeyFactory keyFactory = KeyFactory.getInstance("ECDSA", "BC");
ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp256r1");

ECPoint Q = ecSpec.getG().multiply(privateKey.getD());
byte[] publicDerBytes = Q.getEncoded(false);

ECPoint point = ecSpec.getCurve().decodePoint(publicDerBytes);
ECPublicKeySpec pubSpec = new ECPublicKeySpec(point, ecSpec);
ECPublicKey publicKeyGenerated = (ECPublicKey) keyFactory.generatePublic(pubSpec);

// Generated public key from private key
System.out.print("Generated Public Key: " +
        BaseEncoding.base64Url().encode(publicKeyGenerated.getEncoded()));