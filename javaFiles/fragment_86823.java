// arrive a string like this 04456cb4ba8ee9263311485baa8562c27991f7ff22d59f3d8245b9a05661d159911b632a6f8a7a080d82f4ca77e4d12bb201b89c8ec93f61d5b4dd22df42e1b482
Map<String, Object> result = new HashMap<>();
    try {

        // set provider
        Security.addProvider(new BouncyCastleProvider());

        // transform from hex to ECPublicKey
        byte[] ecRawExternalPublicKey = this.toByte(externalRawPublicKey);
        ECPublicKey ecExternalPublicKey = null;
        KeyFactory externalKeyFactor = null;

        ECNamedCurveParameterSpec ecExternalNamedCurveParameterSpec = ECNamedCurveTable.getParameterSpec("secp256r1");
        ECCurve curve = ecExternalNamedCurveParameterSpec.getCurve();
        EllipticCurve ellipticCurve = EC5Util.convertCurve(curve, ecExternalNamedCurveParameterSpec.getSeed());
        java.security.spec.ECPoint ecPoint = ECPointUtil.decodePoint(ellipticCurve, ecRawExternalPublicKey);
        java.security.spec.ECParameterSpec ecParameterSpec = EC5Util.convertSpec(ellipticCurve, ecExternalNamedCurveParameterSpec);
        java.security.spec.ECPublicKeySpec externalPublicKeySpec = new java.security.spec.ECPublicKeySpec(ecPoint, ecParameterSpec);

        externalKeyFactor = java.security.KeyFactory.getInstance("EC");
        // this is externalPubicKey
        ecExternalPublicKey = (ECPublicKey) externalKeyFactor.generatePublic(externalPublicKeySpec);

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDH", "BC");
        keyGen.initialize(new ECGenParameterSpec("secp256r1"), new SecureRandom());

        KeyPair pair = keyGen.generateKeyPair();
        ECPublicKey pub = (ECPublicKey)pair.getPublic();
        ECPrivateKey pvt = (ECPrivateKey)pair.getPrivate();

        byte[] pubEncoded = pub.getEncoded();
        byte[] pvtEncoded = pvt.getEncoded();

        KeyAgreement keyAgree = KeyAgreement.getInstance("ECDH");
        keyAgree.init(pvt);
        keyAgree.doPhase(ecExternalPublicKey, true);

        System.out.println("sharedKey: "+ this.bytesToHex( keyAgree.generateSecret() ));

        // internal public key
        return "04"+ pub.getW().getAffineX().toString(16) + pub.getW().getAffineY().toString(16)

    }
    catch (Exception e ){
        e.printStackTrace();
        return null;
    }