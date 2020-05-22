public static void main(String[] args) throws Exception {

    String encText = "EAAAADE2ODA2NjQya2JNN2M1ISShgi+Oi5tbsPgOz5KsCHj0";
    final String password = "KJH#$@kds32@!kjhdkftt";
    final String iv = "16806642kbM7c5!$";
    byte[] salt = new byte[] { 34, (byte) 134, (byte) 145, 12, 7, 6, (byte) 243, 63, 43, 54, 75, 65, 53, 2, 34, 54,
            45, 67, 64, 64, 32, (byte) 213 };

    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1000, 256);
    SecretKey tmp = factory.generateSecret(spec);

    SecretKeySpec secret = new SecretKeySpec(tmp.getEncoded(), "AES");
    IvParameterSpec ivs = new IvParameterSpec(iv.getBytes(StandardCharsets.US_ASCII));

     // your code use PKCS7, but I use PKCS5 because it shows exception in my case
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, secret, ivs);

    // base64 string from C# output
    String plaintext = new String(cipher.doFinal(Base64.getDecoder().decode("oYIvjoubW7D4Ds+SrAh49A==")), "UTF-8");
    System.out.println(plaintext);
}