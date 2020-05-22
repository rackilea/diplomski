public static void main(String[] args) throws Exception {

  Random random = new Random();
  byte[] key = new byte[32];
  random.nextBytes(key);

  byte[] plaintext = new byte[100];
  random.nextBytes(plaintext);

  Cipher enc = aes_Gen_with_Key(key);

  byte[] ciphertext = enc.doFinal(plaintext);
  byte[] iv = enc.getIV();

  Cipher dec = aes_Dec_with_Key(key, iv);

  byte[] recoveredPlaintext = dec.doFinal(ciphertext);

  System.out.println(Arrays.equals(plaintext, recoveredPlaintext));    
}