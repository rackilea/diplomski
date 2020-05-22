public void decrypt(InputStream in, OutputStream out) {
    try {
        // Bytes read from in will be decrypted
        in = new CipherInputStream(in, dcipher);

        // Read in the decrypted bytes and write the cleartext to out
        int numRead = 0;
        while ((numRead = in.read(buf)) >= 0) {
            out.write(buf, 0, numRead);
        }
        out.close();
    } catch (java.io.IOException e) {
    }
}