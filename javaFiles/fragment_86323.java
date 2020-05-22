PdfStamper stamper = PdfStamper.createSignature(super.reader, this.os, '\0',null,true);
PdfSignatureAppearance sigApp = stamper.getSignatureAppearance();

if(signatureFieldName==null){
 //for new signatures
 sigApp.setVisibleSignature(new Rectangle(lowerLeftX, lowerLeftY, upperRightX, upperRightY),pageNumber, signatureFieldName);
}
else{
  //existing signatures
  sigApp.setVisibleSignature(signatureFieldName);
}
sigApp.setAcro6Layers(true);
sigApp.setLayer4Text("");
//signer name
sigApp.setLayer2Text("");
//No question mark should appear -> overwrite layer 1
PdfTemplate t = sigApp.getLayer(1);
t.setBoundingBox(new Rectangle(100, 100));
t.setLiteral("% DSBlank\n");

sigApp.setReason("I agree");
sigApp.setLocation("Your location");
sigApp.setImage(Image.getInstance(yourImageOfASignature));
sigApp.setImageScale(0f);
sigApp.setSignDate(signingTime);

PdfSignature dic = new PdfSignature(PdfName.ADOBE_PPKLITE,PdfName.ADBE_PKCS7_DETACHED); 
dic.setDate(new PdfDate(signingTime));
dic.setName(PdfPKCS7.getSubjectFields((X509Certificate)this.chain[0]).getField("CN"));

sigApp.setCryptoDictionary(dic);
int estimatedSize=8192;

HashMap<PdfName, Integer> exclusions = new HashMap<>();
exclusions.put(PdfName.CONTENTS, Integer.valueOf(estimatedSize*2+2));
sigApp.preClose(exclusions);

//hash pdfSigApp.getRangeStream() and create a PKCS#7 signature container in a byte[] signatureContent
PdfPKCS7 pk7 = new PdfPKCS7(this.privateKey, this.chain, null, "SHA-256", null, false);
MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
byte[] buf = new byte[estimatedSize];
int n;
InputStream inp = sigApp.getRangeStream();
while ((n = inp.read(buf)) > 0) {
    messageDigest.update(buf, 0, n);
}
inp.close();
byte[] hash = messageDigest.digest();
byte[] sh = pk7.getAuthenticatedAttributeBytes(hash, signTime, null);
pk7.update(sh, 0, sh.length);
PdfDictionary dic2 = new PdfDictionary();
byte[] encodedSig = pk7.getEncodedPKCS7(hash, signTime);
byte[] paddedSig = new byte[estimatedSize];

//insert pkcs7 container
if(encodedSig.length>paddedSig.length){
    throw new SigningException("Internal signing error - signature size constraints must be increased.");
}
System.arraycopy(encodedSig, 0, paddedSig, 0, encodedSig.length);
dic2.put(PdfName.CONTENTS, new PdfString(paddedSig).setHexWriting(true));
sigApp.close(dic2);