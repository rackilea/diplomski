File pubKeyFile = new File("keys/serverPublicKey.der");
byte[] buffer = new byte[(int) pubKeyFile.length()];

DataInputStream in = new DataInputStream(new FileInputStream(pubKeyFile));
in.readFully(buffer);
in.close();

KeyFactory keyFactory = KeyFactory.getInstance("RSA");
RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(buffer));