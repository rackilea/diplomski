public void encrypt(InputStream in, OutputStream out) {
    try {
        // Bytes written to out will be encrypted
        out = new CipherOutputStream(out, ecipher);

        // Read in the cleartext bytes and write to out to encrypt
        int numRead = 0;
        while ((numRead = in.read(buf)) >= 0) {
            out.write(buf, 0, numRead);
        }
        out.close();
    } catch (java.io.IOException e) {
    }
}