KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
kpg.initialize(2048);
KeyPair keyPair = kpg.generateKeyPair();
PublicKey pub = keyPair.getPublic();
PrivateKey prv = keyPair.getPrivate();

byte[] pubBytes = pub.getEncoded();
byte[] prvBytes = prv.getEncoded();

// now save pubBytes or prvBytes

// to recover the key
KeyFactory kf = KeyFactory.getInstance("RSA");
PrivateKey prv_recovered = kf.generatePrivate(new PKCS8EncodedKeySpec(prvBytes));
PublicKey pub_recovered = kf.generatePublic(new X509EncodedKeySpec(pubBytes));

System.out.println("Private Key: \n" + prv_recovered.toString());
System.out.println("Public Key: \n" + pub_recovered.toString());