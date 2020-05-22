byte[] yBinary = Base64.decodeBase64(mbedtlspub.getBytes()); 
BigInteger y = new BigInteger(yBinary); 
DHPublicKeySpec dhPublicKeySpec = new DHPublicKeySpec(y, dhParams.getP(), dhParams.getG()); 
KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM); 
DHPublicKey mbedtlsPubKey = (DHPublicKey) KeyFactory.generatePublic(dhPublicKeySpec);
aliceKeyAgree.doPhase(mbedtlsPubKey, true);
byte[] javaSecretKey = aliceKeyAgree.generateSecret();