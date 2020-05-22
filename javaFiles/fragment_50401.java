RSAPrivateCrtKeySpec prvkeySpec = new RSAPrivateCrtKeySpec(
        modulus, publicExponent, privateExponent, primeP,
        primeQ, primeExponentP, primeExponentQ,
        crtCoefficient);
Security.addProvider(new org.bouncycastle.jce
        .provider.BouncyCastleProvider());
KeyFactory kfact = KeyFactory.getInstance("RSA", "BC");
BCRSAPrivateCrtKey prk = (BCRSAPrivateCrtKey) kfact
       .generatePrivate(prvkeySpec);