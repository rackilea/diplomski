public static SecretKey generateSecretKey()
{  
   KeyGenerator keyGener  = KeyGenerator.getInstance("AES");
   keyGener.init(256)   // here you can pass any valid length
   return keyGener.generateKey();
}