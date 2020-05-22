Store store = session.getStore("imaps");
store.connect("imap.gmail.com", "user@gmail.com", "gmailPassword");
System.out.println(store);

Folder inbox = store.getFolder("MyFolder");
inbox.open(Folder.READ_ONLY);
Message messages[] = inbox.getMessages();

for (Message message : messages) {
    KeyStore ks = KeyStore.getInstance("pkcs12");

    FileInputStream fis = new FileInputStream("c:\\key.pfx");
    String password = "pfxPassword";

    ks.load(fis, password.toCharArray());
    String alias = ks.aliases().nextElement();

    PrivateKey pKey = (PrivateKey) ks.getKey(alias, password.toCharArray());
    X509Certificate cert = (X509Certificate) ks.getCertificate(alias);

    RecipientId recId = new RecipientId();

    recId.setSerialNumber(cert.getSerialNumber());
    recId.setIssuer(cert.getIssuerX500Principal().getEncoded());

    SMIMEEnveloped m = new SMIMEEnveloped((MimeMessage) message);
    RecipientInformationStore recipients = m.getRecipientInfos();
    RecipientInformation recipient = recipients.get(recId);

    MimeBodyPart res = SMIMEUtil.toMimeBodyPart(recipient.getContent(pKey, ks.getProvider().getName()));

    MimeMultipart parts=(MimeMultipart) res.getContent();

    for (int i=0;i<parts.getCount();i++){
        BodyPart part=parts.getBodyPart(i);
        if (part.getContentType().contains("application/octet-stream")){
            //System.out.println(IOUtils.toString((InputStream) part.getContent()));
            ZipInputStream zin = new ZipInputStream((InputStream)part.getContent());
            ZipEntry entry;
            while((entry = zin.getNextEntry()) != null) {
                System.out.println(IOUtils.toString(zin));
            }
        }
    }
}