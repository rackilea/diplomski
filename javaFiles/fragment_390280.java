BigInteger modBigInteger = new BigInteger(1, modulus);//modulus must be byte array
BigInteger exBigInteger = new BigInteger(1, exponent);//exp must be byte array

RSAPublicKeySpec spec = new RSAPublicKeySpec(modBigInteger, exBigInteger);
KeyFactory factory = KeyFactory.getInstance("RSA");
PublicKey publicKey = factory.generatePublic(spec);