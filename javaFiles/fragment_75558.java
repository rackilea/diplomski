public static void main(String[] args) throws IOException, GeneralSecurityException {
  // get a handle on the base64 encoded key and certificate
  File privateKeyFile = new File("private.der.b64");
  File publicKeyFile = new File("public.der.b64");

  // pull them into arrays
  byte[] privateKeyBytes = toByteArray(privateKeyFile);
  byte[] publicKeyBytes = toByteArray(publicKeyFile);

  // decode them
  privateKeyBytes = toDecodedBase64ByteArray(privateKeyBytes);
  publicKeyBytes = toDecodedBase64ByteArray(publicKeyBytes);

  // get the private key
  KeyFactory keyFactory = KeyFactory.getInstance("RSA");
  KeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
  PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

  // get the public key
  CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
  Certificate certificate = certificateFactory.generateCertificate(new ByteArrayInputStream(publicKeyBytes));
  PublicKey publicKey = certificate.getPublicKey();
}

private static byte[] toByteArray(File file) throws IOException {
  // java 7's try-with-resources statement
  try (FileInputStream in = new FileInputStream(file);
      FileChannel channel = in.getChannel()) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    channel.transferTo(0, channel.size(), Channels.newChannel(out));
    return out.toByteArray();
  }
}

private static byte[] toDecodedBase64ByteArray(byte[] base64EncodedByteArray) {
  return DatatypeConverter.parseBase64Binary(
      new String(base64EncodedByteArray, Charset.forName("UTF-8")));
}