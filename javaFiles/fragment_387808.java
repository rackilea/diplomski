public static void main(String[] args) throws GeneralSecurityException, IOException {
      System.out.println(loadPublicKey(Public));

  }

  public static Key loadPublicKey(String stored) throws GeneralSecurityException, IOException 
  {
 byte[] data = Base64.getDecoder().decode((stored.getBytes()));
 X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
 KeyFactory fact = KeyFactory.getInstance("RSA");
 return fact.generatePublic(spec);

   }