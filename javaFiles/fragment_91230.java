@Cleanup
 FileReader privateKeyReader = new FileReader(new File("key.pem"));
 @Cleanup
 PEMParser parser = new PEMParser(privateKeyReader);

 PEMKeyPair keyPair = (PEMKeyPair) parser.readObject();
 AsymmetricKeyParameter privateKey = PrivateKeyFactory
     .createKey(keyPair.getPrivateKeyInfo());
 AsymmetricKeyParameter publicKey = PublicKeyFactory
     .createKey(keyPair.getPublicKeyInfo());