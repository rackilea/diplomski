Properties props = new Properties();
Session session = Session.getDefaultInstance(props, null);

try {
    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress("admin@example.com", "Example.com Admin"));
    msg.addRecipient(Message.RecipientType.TO, new InternetAddress("user@example.com", "Mr. User"));
    msg.setSubject("My subject");

    String htmlBody;        // ...
    byte[] attachmentData;  // your audio file as an array of bits

    Multipart mp = new MimeMultipart();

    MimeBodyPart htmlPart = new MimeBodyPart();
    htmlPart.setContent(htmlBody, "text/html");
    mp.addBodyPart(htmlPart);

    MimeBodyPart attachment = new MimeBodyPart();
    attachment.setFileName("myfile.mp3"); // we will use mp3 as an example
    DataSource src = new ByteArrayDataSource(attachmentData, "audio/mpeg");
    attachment.setDataHandler(new DataHandler(src));
    mp.addBodyPart(attachment);

    msg.setContent(mp);
    Transport.send(msg);

} catch (AddressException e) {
    // ...
} catch (MessagingException e) {
    // ...
}