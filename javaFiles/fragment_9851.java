public class Main {


    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(main.encrypt("test","d%D*G-JaXdRgUkXs"));

    }
    private SecretKeySpec setKey(String myKey)
    {
        try {
            byte[] key = myKey.getBytes("UTF-8");

            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            return secretKey;
        }
        catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    synchronized public String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            SecretKeySpec secretKey = setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    synchronized public String decrypt(String strToDecrypt, String secret) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
    {
        SecretKeySpec secretKey = setKey(secret);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    }
}