static void SO37248569() throws Exception {
    // fixed key; in real use key should be securely provided or generated
    String keyhex = "6c616d70736865657031323334353637";
    // crude way of converting hex to bytes, better ways are possible
    byte[] key  = new BigInteger (keyhex,16).toByteArray();
    if( key.length > 16 ) key = Arrays.copyOfRange (key, 1, key.length); // maybe signed
    if( key.length != 16 ) throw new Exception ("key length wrong!");
    // all-zero IV, only secure if key is unique every time
    byte[] IV = new byte[16];
    //
    // fixed plaintext for example, in real use obtain as needed
    byte[] plainbytes = "Hello world".getBytes();
    // note: for ASCII-only data the Java default encoding is okay;
    // if real data can or could contain other chars, specify a 
    // suitable encoding; "UTF-8" is good for most text-y data 
    //
    // ENCRYPT: we need to add zero padding ourself since JCE doesn't do that
    // Java makes this easy because arrays are initialized to all-zeros
    if( plainbytes.length %16 !=0 ) 
        plainbytes = Arrays.copyOf (plainbytes, (plainbytes.length /16 +1)*16);
    //
    Cipher aes = Cipher.getInstance ("AES/CBC/NoPadding");
    aes.init (Cipher.ENCRYPT_MODE, new SecretKeySpec (key, "AES"), new IvParameterSpec (IV));
    byte[] cipherbytes = aes.doFinal (plainbytes);
    // crude way of converting bytes to hex, again better possible
    System.out.println ("encrypt hex->" + new BigInteger (1,cipherbytes).toString(16));
    // alternatively just write to a file and let other tools handle
    //
    // DECRYPT: assuming bytes read from file, or already converted from hex
    //same as above: Cipher aes = Cipher.getInstance ("AES/CBC/NoPadding");
    aes.init (Cipher.DECRYPT_MODE, new SecretKeySpec (key, "AES"), new IvParameterSpec (IV));
    byte[] resultbytes = aes.doFinal (cipherbytes);
    //
    // now we need to remove the zero padding, which is ambiguous 
    // this will damage data that actually has trailing zero bytes
    int i; for( i = resultbytes.length; --i>=0 && resultbytes[i]==0; ){}
    resultbytes = Arrays.copyOf (resultbytes, i+1);
    //
    // for example just display, for real use adapt as desired
    System.out.println ("decrypt chars->" + new String (resultbytes));
    // see above about encoding
}