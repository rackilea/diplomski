// Decrypt
byte[] decryptedBytes = (new BigInteger(1, cipherBytes)).modPow(pub.getPublicExponent(), pub.getModulus()).toByteArray();

// Extract msg
int dataStart;
for (dataStart = 0; decryptedBytes[msgStart] != 0; dataStart++);
dataStart++;

byte finalBytes[] = new byte[decryptedBytes.length - msgStart];
System.arraycopy(decryptedBytes, msgStart, finalBytes, 0, finalBytes.length);