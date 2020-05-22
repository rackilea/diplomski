System.out.print("Enter ciphertext: ");
byte[] encrypted = Base64.getDecoder().decode(dataIn.readLine());
...
cipher.init(Cipher.DECRYPT_MODE, aesKey);
String decrypted = new String(cipher.doFinal(encrypted));
System.err.println("Decrypted: " + decrypted);