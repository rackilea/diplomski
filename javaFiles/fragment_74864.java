private PemObject createPemObject(Object o){
  ...
  else if (o instanceof PublicKey)
  {
      type = "PUBLIC KEY";

      encoding = ((PublicKey)o).getEncoded();
  }
  ...
  return new PemObject(type, encoding);
}