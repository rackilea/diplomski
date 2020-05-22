File privKeyFile = new File("keys/clientPrivateKey.der");
byte[] buffer = new byte[(int) privKeyFile.length()];

DataInputStream in = new DataInputStream(new FileInputStream(privKeyFile));
in.readFully(buffer);
in.close();

KeyFactory keyFactory = KeyFactory.getInstance("RSA");
RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(buffer));