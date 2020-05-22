PublicKey publicKey = keyPair.getPublic();
StringWriter writer = new StringWriter();
PemWriter pemWriter = new PemWriter(writer);
pemWriter.writeObject(new PemObject("PUBLIC KEY", publicKey.getEncoded()));
pemWriter.flush();
pemWriter.close();
return writer.toString();