X509Certificate generatedCertificate = (X509Certificate)getKeystore().getCertificate(r.keystoreAlias);
PrivateKey      privateRequestKey    = (PrivateKey)getKeystore().getKey("alias", "password".toCharArray());
Signature       signature            = Signature.getInstance("MD5WithRSA");

signature.initSign(privateRequestKey);

X500NameBuilder x500NameBld = new X500NameBuilder(BCStyle.INSTANCE);

//possibly less or more of these, depending on your needs
x500NameBld.addRDN(BCStyle.C, "country");
x500NameBld.addRDN(BCStyle.O, "ORG");
x500NameBld.addRDN(BCStyle.E, "email");
x500NameBld.addRDN(BCStyle.CN, "SubjectName");
x500NameBld.addRDN(BCStyle.SN, "12345678");


X500Name                   subject = x500NameBld.build();
PKCS10CertificationRequest req     = new PKCS10CertificationRequest("MD5WithRSA",X509Name.getInstance(subject),generatedCertificate.getPublicKey(),new DERSet(),privateRequestKey);