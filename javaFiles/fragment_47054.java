SMIMESignedGenerator gen = new SMIMESignedGenerator();
SignerInfoGenerator sigGen = new JcaSimpleSignerInfoGeneratorBuilder()
        .setProvider(BC)
        .build("SHA1withRSA", senderKey, senderCert);
gen.addSignerInfoGenerator(sigGen);
MimeMultipart smime = gen.generate(part);
MimeBodyPart tmpBody = new MimeBodyPart();
tmpBody.setContent(smime);
tmpBody.setHeader("Content-Type", smime.getContentType());
return tmpBody;