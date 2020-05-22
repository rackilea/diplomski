import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service("mailNotificationService")
public class MailNotificationService {
  @Value("${mail.name}")
  String mailFrom;

  @Resource
  private JavaMailSender javaMailSender;

  public void notify(String to, String subject, String message) {
    try {
      InternetAddress[] parsed;
      try {
        parsed = InternetAddress.parse(to);
      } catch (AddressException e) {
        throw new IllegalArgumentException("Not valid email: " + to, e);
      }

      MimeMessage mailMessage = javaMailSender.createMimeMessage();
      mailMessage.setSubject(subject, "UTF-8");

      MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "UTF-8");
      helper.setFrom(mailFrom);
      helper.setTo(parsed);
      helper.setText(message, true);

      javaMailSender.send(mailMessage);
    } catch (MessagingException ex) {
      throw new RuntimeException(ex);
    }
  }
}