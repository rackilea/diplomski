import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class emailTest {

    public static void main(String[] args) {
        String to = "example@live.com";
        String from = "example@live.com";

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.live.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");


        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Java");

            message.setText("Java");

            Transport trans = session.getTransport("smtp");
            trans.connect("smtp.live.com", 587, "example@live.com", "password");
            trans.sendMessage(message, message.getAllRecipients());

            System.out.println("Message Sent!");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}