g.init(new ECKeyGenerationParameters(ecP, new SecureRandom()));

    // Generate key pair
    AsymmetricCipherKeyPair aKeys = g.generateKeyPair();

    ECParameterSpec ecSpec = new ECParameterSpec(ecP.getCurve(), ecP.getG(), ecP.getN());
    JCEECPublicKey jpub = new JCEECPublicKey("EC",
            (ECPublicKeyParameters) aKeys.getPublic(), ecSpec);
    JCEECPrivateKey jpriv = new JCEECPrivateKey("EC",
            (ECPrivateKeyParameters) aKeys.getPrivate(), jpub,  ecSpec);