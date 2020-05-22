KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
    FileInputStream io = new FileInputStream("path/to/jks/file.jks");
    try{
        keystore.load(io, "pass".toCharArray());
    } finally {
        io.close();
    }