@Test
    public void testPythonCompatibility() {
        // Arrange
        byte[] cipher_key = org.bouncycastle.util.encoders.Hex.decode("0123456789ABCDEFFEDCBA9876543210");
        final int HALF_BLOCK = 64;
        byte[] salt = org.bouncycastle.util.encoders.Hex.decode("0123456789ABCDEF");
        byte[] nonceAndCounter = new byte[16];
        System.arraycopy(salt, 0, nonceAndCounter, 0, ((int) (HALF_BLOCK / 8)));
        IvParameterSpec iv = new IvParameterSpec(nonceAndCounter);
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding", "BC");
        SecretKeySpec key = new SecretKeySpec(cipher_key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        final String plaintext = "This is a plaintext message.";

        // Act
        byte[] cipherBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        // Assert
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] recoveredBytes = cipher.doFinal(cipherBytes);
        String recovered = new String(recoveredBytes, StandardCharsets.UTF_8);
        assert recovered.equals(plaintext);
    }