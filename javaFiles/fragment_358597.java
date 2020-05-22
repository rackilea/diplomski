private static Boolean isValid(String xiString, String xiSig)
{
  AsnKeyParser keyParser = new AsnKeyParser("path/to/key.public");
  DSAParameters publicKey = keyParser.ParseDSAPublicKey();

  DSACryptoServiceProvider DSA = new DSACryptoServiceProvider();
  DSA.ImportParameters(publicKey);
  DSASignatureDeformatter DSADeformatter = new DSASignatureDeformatter(DSA);
  UTF8Encoding UTF8 = new UTF8Encoding();
  byte[] plainBytes = UTF8.GetBytes(xiString);      
  var sha1 = new SHA1Managed();
  var hash = sha1.ComputeHash(plainBytes);
  byte[] asn1SigBytes = Convert.FromBase64String(xiSig);
  byte[] sigBytes = ConvertToP1363Signature(asn1SigBytes);
  Boolean retVal = DSADeformatter.VerifySignature(hash, sigBytes);
  return retVal;
}