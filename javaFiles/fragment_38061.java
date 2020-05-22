@Stateless
public class MailSenderBean {

public void sendEmail(String fromEmail, String username, String password, String toEmail, String subject, String message) throws MessagingException{

    Properties props = System.getProperties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.fallback", "false");


    Session mailSession = Session.getDefaultInstance(props, null);
    mailSession.setDebug(true);

    Message mailMessage = new MimeMessage(mailSession);

    mailMessage.setFrom(new InternetAddress(fromEmail));
    mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
    mailMessage.setContent(message, "text/html");       
    mailMessage.setSubject(subject);

    Transport transport = mailSession.getTransport("smtp");
    transport.connect("smtp.gmail.com", username, password);

    BodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setText("File attached:");
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);
    messageBodyPart = new MimeBodyPart();

    DataSource source = new FileDataSource("location\of\file");
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(filename);
    multipart.addBodyPart(messageBodyPart);
    mailMessage.setContent(multipart);

    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());


}
}