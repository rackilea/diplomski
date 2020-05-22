KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
gen.initialize(2048);
KeyPair pair = gen.generateKeyPair();
try (OutputStream os = Files.newOutputStream(Paths.get("public.der"), StandardOpenOption.CREATE_NEW)) {
  os.write(pair.getPublic().getEncoded());
  os.flush();
}
try (OutputStream os = Files.newOutputStream(Paths.get("private.der"), StandardOpenOption.CREATE_NEW)) {
  os.write(pair.getPrivate().getEncoded());
  os.flush();
}