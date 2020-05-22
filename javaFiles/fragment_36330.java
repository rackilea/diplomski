PublicKey publicKey = key.getPublic();
byte[] encodedPublicKey = publicKey.getEncoded();
String b64PublicKey = Base64.getEncoder().encodeToString(encodedPublicKey);

try (OutputStreamWriter publicKeyWriter =
        new OutputStreamWriter(
                new FileOutputStream(publicKeyFile),
                StandardCharsets.US_ASCII.newEncoder())) {
    publicKeyWriter.write(b64PublicKey);
}