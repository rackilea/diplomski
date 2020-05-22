public byte[] encrypt(String message, String key, String iv) throws Exception {
        Cipher encrypt = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec secretKey = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
        encrypt.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(Base64.getDecoder().decode(iv)));
        return encrypt.doFinal(/*Get bytes from your message*/message.getBytes(StandardCharsets.UTF_8));
    }

    public String decrypt(String encryptedMessage, String key, String iv) throws Exception{
        Cipher decrypt = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec secretKey = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
        decrypt.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(Base64.getDecoder().decode(iv)));
        return new String(decrypt.doFinal(Base64.getDecoder().decode(encryptedMessage)), StandardCharsets.UTF_8);
    }