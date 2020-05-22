public byte[] decrypt(byte[] data) throws IllegalBlockSizeException,
    BadPaddingException, IOException {

  ByteArrayOutputStream bos = new ByteArrayOutputStream();    
  int nread = 0;
  byte[] substr = new byte[16];
  try (InputStream fin = new ByteArrayInputStream(data);
      CipherInputStream cin = new CipherInputStream(fin, mDecipher)) {
    while ((nread = cin.read(substr)) > 0) {
      bos.write(substr, 0, nread);
    }

    return bos.toByteArray();
  }
}

public byte[] encrypt(byte[] data) throws IllegalBlockSizeException,
    BadPaddingException, IOException {
  System.out.println("data.length=" + data.length);
  ByteArrayOutputStream bos = new ByteArrayOutputStream();

  int nread = 0;
  byte[] substr = new byte[16];
  try (ByteArrayInputStream fin = new ByteArrayInputStream(data);
      CipherInputStream cin = new CipherInputStream(fin, mEcipher)) {
    while ((nread = cin.read(substr)) > 0) {
      bos.write(substr, 0, nread);
    }
    return bos.toByteArray();
  }
}