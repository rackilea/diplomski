KeyPairGenerator mcElieceKeyPairGenerator = KeyPairGenerator.getInstance("McEliece");
mcElieceKeyPairGenerator.initialize(keysize, new SecureRandom());
kp = mcElieceKeyPairGenerator.generateKeyPair();

final byte[] publicKeyData = kp.getPublic().getEncoded(); 
X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyData);
KeyFactory mcElieceKeyFactory = KeyFactory.getInstance("McEliece");
PublicKey regeneratedPublicKey = mcElieceKeyFactory.generatePublic(publicKeySpec);

final byte[] privateKeyData = kp.getPrivate().getEncoded();
PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyData);
PrivateKey regeneratedPrivateKey = mcElieceKeyFactory.generatePrivate(privateKeySpec);