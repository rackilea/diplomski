int bitLength = 512;
String plainText = "teststring";

// Convert to bytes
byte plainBytes[] = plainText.getBytes(); 

byte encryptionBytes[] = new byte[bitLength / 8];

encryptionBytes[0] = 0; // Leading 0
encryptionBytes[1] = 1; // Block type

// Padding String
int paddingEnd = (bitLength / 8) - plainBytes.length - 2;
for (int i = 2; i < paddingEnd; i++) {
    encryptionBytes[i] = (byte) 0xff;
}
encryptionBytes[paddingEnd + 1] = 0;

// Actual data
System.arraycopy(plainBytes, 0, encryptionBytes, paddingEnd + 1, plainBytes.length);

// Encrypt
byte[] cipherBytes = (new BigInteger(1, encryptionBytes)).modPow(priv.getPrivateExponent(), priv.getModulus()).toByteArray();