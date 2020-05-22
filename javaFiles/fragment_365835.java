@Slf4j
public class EmailSenderExample {

   private MailSender mailSender;
   private SimpleMailMessage templateMessage;

   public void sendMail() {
       log.info("Sending email...");

       // Create a thread-safe "copy" of the template message and customize it.
       SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
       msg.setTo("flynn@encom.com");
       msg.setText("Greetings, programs!");

       try {
            mailSender.send(msg);
       } catch (MailException ex) {
            log.warn("Email sending failed", ex);
       }
   }
}