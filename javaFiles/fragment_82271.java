Properties props = new Properties();
props.setProperty("mail.transport.protocol", "smtp");
props.setProperty("mail.smtp.host", "out.alice.it");
props.setProperty("mail.smtp.auth", "true");
final PasswordAuthentication auth = new PasswordAuthentication(smtpUser, stmpPassword);
Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() { return auth; }
});
MimeMessage message = ....;
// compose the message
Transport.send(message);