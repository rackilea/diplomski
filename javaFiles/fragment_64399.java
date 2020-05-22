StringWriter writer = new StringWriter();
PemWriter pemWriter = new PemWriter(writer);
pemWriter.writeObject(new PemObject("CERTIFICATE REQUEST", CSRder));
pemWriter.flush();
pemWriter.close();
String csrPEM = writer.toString();