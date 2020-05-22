Authenticator auth = new MailAuthenticator();
    Session session = Session.getInstance(properties, auth);
    Message msg = new MimeMessage(session);
    msg.setSubject(subject);
    msg.setSentDate(new Date());
    msg.setFrom(new InternetAddress(from, false));
    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rcpt, false));
    msg.setContent(msgContent, "text/html");
    Transport.send(msg);