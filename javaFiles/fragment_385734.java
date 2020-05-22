// --- key pair with private key for testing
KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
gen.initialize(4096);
KeyPair kp = gen.generateKeyPair();

// --- create KEK
final byte[] kek = new byte[16]; // test value
SecretKey sKey = new SecretKeySpec(kek, "AES");

// --- the cipher, not a special wrapping algorithm
Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");

// --- create IV
// not really necessary because the modulus comes first, but nicer
SecureRandom rng = new SecureRandom();
byte[] ivBytes = new byte[c.getBlockSize()];
rng.nextBytes(ivBytes);
IvParameterSpec iv = new IvParameterSpec(ivBytes);

// --- init & wrap by normal encryption
c.init(Cipher.WRAP_MODE, sKey, iv);
byte[] result = c.wrap(kp.getPrivate());