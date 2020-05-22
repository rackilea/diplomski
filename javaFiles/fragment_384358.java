private String decrypt(String cadena, String password)throws Exception{
    SecretKeySpec keySpec= generateKey(password);
    Cipher c= Cipher.getInstance(AES_MODE);
    c.init(Cipher.DECRYPT_MODE,keySpec);
    byte[] decValue= c.doFinal(Base64.decode(cadena, Base64.DEFAULT));
    //               ^^^^^^^^^  add this
    String decryptedValue= new String((decValue));
    return decryptedValue;
}