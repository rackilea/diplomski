Security.addProvider(new BouncyCastleProvider());    
PEMReader reader = new PEMReader(new StringReader(rsaPublicKeyString));    
BCRSAPublicKey key = (BCRSAPublicKey) reader.readObject();
bytes[] = key.getEncoded(); // now in SubjectPublicKeyInfo format.

// as before...