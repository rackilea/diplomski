//Generate KeyPair
KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
keyGen.initialize(KEY_SIZE, new SecureRandom());
KeyPair keyPair = keyGen.generateKeyPair();

//Generate CSR in PKCS#10 format encoded in DER
PKCS10CertificationRequest csr = CsrHelper.generateCSR(keyPair, commonname);
byte  CSRder[] = csr.getEncoded();