public static void main(String[] args) throws Exception {

    String encText = "EAAAADE2ODA2NjQya2JNN2M1ISShgi+Oi5tbsPgOz5KsCHj0";
    final String password = "KJH#$@kds32@!kjhdkftt";
    byte[] salt = new byte[] { 34, (byte) 134, (byte) 145, 12, 7, 6, (byte) 243, 63, 43, 54, 75, 65, 53, 2, 34, 54,
            45, 67, 64, 64, 32, (byte) 213 };

    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1000, 256);
    SecretKey tmp = factory.generateSecret(spec);

    SecretKeySpec secret = new SecretKeySpec(tmp.getEncoded(), "AES");

    byte[] data = Base64.getDecoder().decode("EAAAADE2ODA2NjQya2JNN2M1ISShgi+Oi5tbsPgOz5KsCHj0");
    // skip first 4 bytes (the length of IV) and get IV byte array
    byte[] iv = Arrays.copyOfRange(data, 4, 20);

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
    // skip IV length (4 bytes) and IV (16 bytes)
    cipher.update(data, 20, data.length - 20);
    String plaintext = new String(cipher.doFinal(), "UTF-8");
    System.out.println(plaintext);
}