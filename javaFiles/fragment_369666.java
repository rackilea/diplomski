KeyGenerator kgen = KeyGenerator.getInstance("AES");
kgen.init(128);
SecretKey key = kgen.generateKey();
byte[] encoded = key.getEncoded();
FileOutputStream output = new FileOutputStream(new File("target-file"));
IOUtils.write(encoded, output);