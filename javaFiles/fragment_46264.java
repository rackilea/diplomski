KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
 kpg.initialize(2048);

 KeyPair kp = kpg.genKeyPair();

 KeyFactory fact = KeyFactory.getInstance("RSA");

 RSAPublicKeySpec pub = fact.getKeySpec(kp.getPublic(),
        RSAPublicKeySpec.class);
 saveToFile(PUBLIC_KEY_FILE, 
        pub.getModulus(), pub.getPublicExponent());

 RSAPrivateKeySpec priv = fact.getKeySpec(kp.getPrivate(),
        RSAPrivateKeySpec.class);
 saveToFile(PRIVATE_KEY_FILE, 
         priv.getModulus(), priv.getPrivateExponent());