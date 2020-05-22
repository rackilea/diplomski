byte[] binaryKey 
  byte [] encrypted
  SecretKeySpec keySpec = new SecretKeySpec(binaryKey, "DES");
  Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
  cipher.init(Cipher.DECRYPT_MODE, keySpec);
  decryptedString = new String(cipher.doFinal(encrypted));