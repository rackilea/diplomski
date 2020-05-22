public String decrypt(String strCipherText) throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException {
    String strDecryptedText = new String();

    // Initialize the Cipher for Encryption
    this.cipher.init(Cipher.DECRYPT_MODE, this.keyObj, this.ivObj);

    // Decode the Base64 text
    byte[] cipherBytes = Base64.decode(strCipherText);

    // Decrypt the Data
    //  a. Initialize a new instance of Cipher for Decryption (normally don't reuse the same object)
    //     Be sure to obtain the same IV bytes for CBC mode.
    //  b. Decrypt the cipher bytes using doFinal method
    byte[] byteDecryptedText = this.cipher.doFinal(cipherBytes);
    strDecryptedText = new String(byteDecryptedText);

    return strDecryptedText;
}