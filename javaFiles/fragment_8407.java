public static SecretKey generateDESkey() {
    KeyGenerator keyGen = null;
    try {
        keyGen = KeyGenerator.getInstance("DESede");
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
    }
    keyGen.init(112); // key length 112 for two keys, 168 for three keys
    SecretKey secretKey = keyGen.generateKey();
    return secretKey;
}