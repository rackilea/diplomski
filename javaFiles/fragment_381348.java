CMSSignedData           s = new CMSSignedData(inputStream);
Store                   certStore = s.getCertificates(); // This is where you access embedded certificates
SignerInformationStore  signers = s.getSignerInfos();
Collection              c = signers.getSigners();
Iterator                it = c.iterator();

while (it.hasNext())
{
  SignerInformation   signer = (SignerInformation)it.next();
  Collection          certCollection = certStore.getMatches(signer.getSID());

  Iterator              certIt = certCollection.iterator();
  X509CertificateHolder cert = (X509CertificateHolder)certIt.next();

  if (signer.verify(new JcaSimpleSignerInfoVerifierBuilder().setProvider("BC").build(cert)))
  {
      verified++;
  } 
}