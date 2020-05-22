ECGenParameterSpec ecParamSpec = new ECGenParameterSpec("secp384r1");
KeyPairGenerator kpg = KeyPairGenerator.getInstance("ECDH", "SC");
kpg.initialize(ecParamSpec);

KeyPair kpA = kpg.generateKeyPair();

BCECPublicKey publicKey = (BCECPublicKey)kpA.getPublic();
BCECPrivateKey privateKey = (BCECPrivateKey)kpA.getPrivate();

byte[] publicKeyBytes = publicKey.getQ().getEncoded(true);
byte[] privateKeyBytes = privateKey.getD().toByteArray();