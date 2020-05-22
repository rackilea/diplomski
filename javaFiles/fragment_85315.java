//How to Check Signature
byte[] r = Arrays.copyOfRange(tokenSignature, 0,tokenSignature.length/2);
byte[] s = Arrays.copyOfRange(tokenSignature, tokenSignature.length/2,tokenSignature.length);

ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
DEROutputStream derOutputStream = new DEROutputStream(byteArrayOutputStream);
ASN1EncodableVector v=new ASN1EncodableVector();
v.add(new ASN1Integer(new BigInteger(1,r)));
v.add(new ASN1Integer(new BigInteger(1,s)));
derOutputStream.writeObject(new DERSequence(v));
byte[] derSignature = byteArrayOutputStream.toByteArray();

ver.update(data);
if (ver.verify(derSignature) == false)
{
  throw new Exception("Signature Verification failed");
}