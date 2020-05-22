MimeMessage message = new MimeMessage(session);
message.addHeader("Content-Type", "multipart/mixed; charset=UTF-8");

Multipart multipart = new MimeMultipart("alternative");

MimeBodyPart messageBodyPartPlain = new MimeBodyPart();
messageBodyPartPlain.setContent("Plain body text", "text/plain; charset=utf-8");
multipart.addBodyPart(messageBodyPartPlain);

MimeBodyPart messageBodyPart = new MimeBodyPart();
messageBodyPart.setContent("Html body text", "text/html; charset=utf-8");
multipart.addBodyPart(messageBodyPart);

MimeBodyPart mbp = new MimeBodyPart();
mbp.setContent(multipart);

Multipart mp2 = new MimeMultipart("mixed");
mp2.addBodyPart(mbp);

for (Attachment a : attachments) {
    if (a != null && a.getFile() != null) {
        MimeBodyPart mbp2 = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(a.getFile()) {
            public String getContentType() {
                return MimeTypeUtils.getContentTypeByFileName(a.getName());
            }
        };
        mbp2.setDataHandler(new DataHandler(fds));
        mbp2.setFileName(a.getName());
        mp2.addBodyPart(mbp2);
    }
}

message.setContent(mp2);