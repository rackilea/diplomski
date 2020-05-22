KeyPairGenerator aliceKpairGen = KeyPairGenerator.getInstance("DH");
aliceKpairGen.initialize(2048);
KeyPair aliceKpair = aliceKpairGen.generateKeyPair();
KeyAgreement aliceKeyAgree = KeyAgreement.getInstance("DH");
aliceKeyAgree.init(aliceKpair.getPrivate());
DHParameterSpec dhParams = ((DHPublicKey) aliceKpair.getPublic()).getParams();
DHParameter dhP = new DHParameter(dhParams.getP(), dhParams.getG(), 0);
byte[] encodedParams = dhP.getEncoded(ASN1Encodable.DER);
byte[] javaPub = ((DHPublicKey)aliceKeyPair.getPublic()).getY().toByteArray();