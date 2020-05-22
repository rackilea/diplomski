KeyGenerator gen;

public AESencrp() throws NoSuchAlgorithmException {
    this.gen = KeyGenerator.getInstance("AES");
    gen.init(128); /* 128-bit AES */
}