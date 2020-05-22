KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

keyPairGenerator.initialize(1024);
keyPair = keyPairGenerator.generateKeyPair();
System.out.println(keyPair.getPrivate());
System.out.println(keyPair.getPublic());