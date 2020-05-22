package org.kodejava.example.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class GmailSendEmailTLS {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        //
        // Email information such as from, to, subject and contents.
        //
        String mailFrom = "email@gmail.com";
        String mailTo = "email@gmail.com";
        String mailSubject = "TLS - Gmail Send Email Demo";
        String mailText = "TLS - Gmail Send Email Demo";

        GmailSendEmailTLS gmail = new GmailSendEmailTLS();
        gmail.sendMail(mailFrom, mailTo, mailSubject, mailText);
    }

    private void sendMail(String mailFrom, String mailTo,
                          String mailSubject, String mailText)
            throws Exception {

        Properties config = createConfiguration();

        //
        // Creates a mail session. We need to supply username and
        // password for Gmail authentication.
        //
        Session session = Session.getInstance(config, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        GmailSendEmailTLS.USERNAME,
                        GmailSendEmailTLS.PASSWORD
                );
            }
        });

        //
        // Creates email message
        //
        Message message = new MimeMessage(session);
        message.setSentDate(new Date());
        message.setFrom(new InternetAddress(mailFrom));
        message.setRecipient(Message.RecipientType.TO,
                new InternetAddress(mailTo));
        message.setSubject(mailSubject);
        message.setText(mailText);

        //
        // Send a message
        //
        Transport.send(message);
    }

    private Properties createConfiguration() {
        return new Properties() {{
            put("mail.smtp.auth", "true");
            put("mail.smtp.host", "smtp.gmail.com");
            put("mail.smtp.port", "587");
            put("mail.smtp.starttls.enable", "true");
        }};
    }
}