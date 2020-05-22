ByteArrayOutputStream baos = new ByteArrayOutputStream();  
bm.compress(Bitmap.CompressFormat.PNG, 100, baos); 
byte[] b = baos.toByteArray();  

byte[] keyStart = "encryption key".getBytes();
KeyGenerator kgen = KeyGenerator.getInstance("AES");
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
sr.setSeed(keyStart);
kgen.init(128, sr); 
SecretKey skey = kgen.generateKey();
byte[] key = skey.getEncoded();    

// encrypt
byte[] encryptedData = encrypt(key,b);
// decrypt
byte[] decryptedData = decrypt(key,encryptedData);