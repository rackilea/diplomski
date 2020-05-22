KeyPairGenerator generator = KeyPairGenerator.getInstance();

int count = 5;

keyPairGenerator.initialize();
KeyPair kPair = generator.genKeyPair();

byte[] privateKey = kPair.getPrivate().getEncoded();

String stringPb = "PBEWithSHA1AndDESede";
String password = "your_own_password";

SecureRandom rndm = new SecureRandom();

PBEParameterSpec paramSpec = new PBEParameterSpec(salt, count);
PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());

SecretKeyFactory factory = SecretKeyFactory.getInstance();
SecretKey pbeKey = factory.generateSecret(keySpec);

Cipher cipher = Cipher.getInstance(stringPb);

cipher.init(ENCRYPT_MODE, pbeKey, paramSpec);

byte[] text = cipher.doFinal();

AlgorithmParameters parametres = AlgorithmParameters.getInstance();
parametres.init(paramSpec);
EncryptedPrivateKeyInfo encinfo = new EncryptedPrivateKeyInfo(parametres, text);