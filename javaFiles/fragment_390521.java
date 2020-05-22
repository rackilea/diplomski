//Encryption side
String text = "hola, hi, anything u want";
byte[] plainText = text.getBytes("UTF-8");
String base64 = encrypt(plainText);

// Decryption side
byte[] cipherText = Base64.decode(base64, Base64.DEFAULT);
String plainEncodedText = decrypt(cipherText);
byte[] plainTextAsByte = Base64.decode(plainEncodedText, Base64.DEFAULT);
String plainTextAgain = new String(plainTextAsByte , "UTF-8");