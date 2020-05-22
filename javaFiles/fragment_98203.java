List<int> encrypt2(String text) {
  // key must be 16 or 32 bytes - not sure how "mykey" could work
  // key should really be binary, not a String! Better to use a KDF.
  Uint8List key = Uint8List.fromList(
    utf8.encode('0123456789abcdef'),
  );

  PaddedBlockCipher cipher = PaddedBlockCipherImpl(
    PKCS7Padding(), // Java defaults to PKCS5 which is equivalent
    ECBBlockCipher(AESFastEngine()), // Very weak mode - don't use this in the real world
  );

  cipher.init(
    true,
    PaddedBlockCipherParameters<CipherParameters, CipherParameters>(
      KeyParameter(key),
      null,
    ),
  );

  return cipher.process(utf8.encode(text)); // this isn't the same as .toBytes, except for ASCII
}