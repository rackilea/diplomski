// Pad key 
byte[] key = padKey("SiadajerSiadajer".getBytes()); 
Key aesKey = new SecretKeySpec(key, "AES");

// Specify block-cipher (AES), mode (CBC) and padding (PKCS5)
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); 

// Create random IV
SecureRandom secureRandom = new SecureRandom();
byte iv[] = new byte[cipher.getBlockSize()];
secureRandom.nextBytes(iv);
IvParameterSpec ivParameterSpec = new IvParameterSpec(iv); 

// Encrypt data
cipher.init(Cipher.ENCRYPT_MODE, aesKey, ivParameterSpec);
byte[] encryptedData = cipher.doFinal(paddedData);