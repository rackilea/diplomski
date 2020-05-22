private static string GetHashedKey()
{
     string hashBase64 = String.Empty;
     using (SHA1Managed sha1 = new SHA1Managed())                                  // builder.mDigestAlgorithm = "SHA1";
     {
          byte[] hash = sha1.ComputeHash(Encoding.UTF8.GetBytes(encryptionKey));   // builder.mCharsetName = "UTF8";
          hashBase64 = Base64ThirdPartAndroid(hash, true);
          //Console.WriteLine("Hash (base64): " + hashBase64);
     }
     return hashBase64;
 }