StaticKeyInfoCredentialResolver keyresolver =
  new StaticKeyInfoCredentialResolver(yourCredential);

Decrypter samlDecrypter = new Decrypter(null, keyresolver, new InlineEncryptedKeyResolver());

Assertion assertion = samlDecrypter.decrypt(response.getEncryptedAssertions().get(0));