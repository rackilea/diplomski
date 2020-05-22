class EmailNotifier {
    private final Session session;

    public EmailNotifier(final String host, final String sender) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.from", sender);
        this.session = Session.getInstance(props, null);
    }

    public void send(String to, String subject, String body) {
        try {
            MimeMessage msg = new MimeMessage(this.session);
            msg.setRecipients(Message.RecipientType.TO, to);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(body);
            Transport.send(msg);
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
    }
}