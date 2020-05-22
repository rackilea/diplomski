PublicKey publicKey = readPublicKey("src/main/resources/key.pem");

String dataToEncrypt = "myMessage";
Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", new BouncyCastleProvider());
cipher.init(Cipher.ENCRYPT_MODE, publicKey);
byte[] encrypted = cipher.doFinal(dataToEncrypt.getBytes(StandardCharsets.UTF_8));