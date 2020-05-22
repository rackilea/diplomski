KeyStore trustStore= KeyStore.getInstance(KeyStore.getDefaultType());
    FileInputStream stream = new FileInputStream("path/to/truststore/file.jks");
    try{
        keystore.load(stream, "trusted".toCharArray());
    } finally {
        stream.close();
    }