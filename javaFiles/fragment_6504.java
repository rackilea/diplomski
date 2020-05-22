byte[] derivation = Hex.decode("202122232425262728292a2b2c2d2e2f");
byte[] encoding = Hex.decode("303132333435363738393a3b3c3d3e3f");
byte[] nonce = Hex.decode("000102030405060708090a0b0c0d0e0f");

Cipher c = Cipher.getInstance("ECIESwithAES-CBC", "BC");
IESParameterSpec params = new IESParameterSpec(derivation, encoding, 128, 128, nonce, true);
c.init(Cipher.ENCRYPT_MODE, publicKey, params);
byte[] ciphertext = c.doFinal(plaintext);