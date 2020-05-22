public class SendMailService {
    private MailSender mailSender;
    private SimpleMailMessage emailTemplate;
    public void sendEmail(String to, String from, String subject, String body) 
                         throws MailException {
        SimpleMailMessage message = new SimpleMailMessage(this.emailTemplate);
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void setEmailTemplate(SimpleMailMessage emailTemplate) {
        this.emailTemplate = emailTemplate;
    }
}