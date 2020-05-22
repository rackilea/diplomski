package so4406538;

import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

public class MailDemo {

  public static void main(String[] args) throws MessagingException, IOException {
    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);
    message.setSubject("Your new InCites\u2122 subscription", "UTF-8");
    message.setContent("hello", "text/plain");
    message.writeTo(System.out);
  }
}