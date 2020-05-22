private static PrivateKey createPrivateKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String publicModulus = "d2c34017ef94f8ab6696dae66e3c0d1ad186bbd9ce4461b68d7cd017c15bda174045bfef36fbf048" +
                "73cfd6d09e3806af3949f99c3e09d6d3c37f6398d8c63f9a3e39b78a187809822e8bcf912f4c44a8" +
                "92fe6a65a477ddea9582738317317286a2610ba30b6b090c3b8c61ffb64207229b3f01afe928a960" +
                "c5a44c24b26f5f91";
        String privateExponent = "6c97ab6369cf00dd174bacd7c37e6f661d04e5af10670d4d88d30148ec188e63227b8dac0c517cf9" +
                "67aa73cd23684c9165dc269f091bfab33b6c5c7db95b54130e348255c30aaaac1c7f09ef701e0d6f" +
                "6dc142d2e4ed78466cc104e28d50be7adf3863afc021dbdd8b5f0b968b7cd965242c7d8d4b32ee84" +
                "0fac3cad134344c1";
        BigInteger privateExponenInt = new BigInteger(privateExponent, 16);
        BigInteger keyInt = new BigInteger(publicModulus, 16);
        RSAPrivateKeySpec privateKeySpec = new RSAPrivateKeySpec(keyInt, privateExponenInt);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(privateKeySpec);
    }