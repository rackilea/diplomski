...

import javax.mail.*;
import javax.mail.internet.*;

...

    try {
        String host = "smtp.gmail.com";
        String username = "program-email@gmail.com";
        String password = "password";
        InternetAddress[] addresses = {new InternetAddress("user@anymail.com"),
            new InternetAddress(bid.email),
            new InternetAddress("another-user@anymail.com")};
        Properties props = new Properties();

        // set any needed mail.smtps.* properties here
        Session session = Session.getInstance(props);
        MimeMessage message = new MimeMessage(session);
        message.setSubject("my subject placed here");
        message.setContent("my message placed here:\n\n"
                + part.toString(), "text/plain");
        message.setRecipients(Message.RecipientType.TO, addresses);

        // set the message content here
        Transport t = session.getTransport("smtps");
        try {
            t.connect(host, username, password);
            t.sendMessage(message, message.getAllRecipients());
        } finally {
            t.close();
        }          
    } catch (MessagingException me) {
        me.printStackTrace();
    }