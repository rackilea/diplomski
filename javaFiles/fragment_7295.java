private static byte[] GetSecretKey()
{
     string hashedKey = GetHashedKey();
     byte[] saltBytes = Encoding.UTF8.GetBytes(salt);                                                // builder.mCharsetName = "UTF8";
     int iterations = 1;                                                                             // builder.mIterationCount = 1
     byte[] secretKey = null;
     using (Rfc2898DeriveBytes rfc2898 = new Rfc2898DeriveBytes(hashedKey, saltBytes, iterations))   // builder.mSecretKeyType = "PBKDF2WithHmacSHA1";
     {
          secretKey = rfc2898.GetBytes(16);                                                          // builder.mKeyLength = 128;
          //Console.WriteLine("Key: " + ByteArrayToHexString(secretKey));
     }
     return secretKey;
 }