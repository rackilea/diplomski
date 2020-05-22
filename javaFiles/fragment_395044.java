String password = ...;
   KeyStore ks = KeyStore.getInstance(KEY_STORE_TYPE);

   byte[] keyAsByteArray = ...; // The key persisted in the DB
   InputStream keyStream = new ByteArrayInputStream(keyAsByteArray);
   ks.load(keyStream, password);