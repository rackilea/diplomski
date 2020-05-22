byte[] decoded = BASE64DecoderStream.decode(KEY.getBytes());
KeyFactory keyFactory = KeyFactory.getInstance("RSA");
PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(decoded));
Signature sig = Signature.getInstance("SHA1withRSA");
sig.initVerify(publicKey);
sig.update(signedData.getBytes());
if (sig.verify(BASE64DecoderStream.decode(signature.getBytes())))
{
    // Valid
}