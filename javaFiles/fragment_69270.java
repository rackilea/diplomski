public static void sendEmail() {
    String to = "abcde@gmail.com";// change accordingly
    final String user = "vwxyz@gmail.com";// change accordingly
    final String password = "xxxxxxx";// change accordingly
    // final String d_port = "465";

    // 1) get the session object
    // java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password);
        }
    });

    // 2) compose message
    try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Message Alert! Changes made to your file");

        // 3) create MimeBodyPart object and set your message text
        BodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("This is message body");

        // 4) create new MimeBodyPart object and set DataHandler object to this object
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();

        String filename = "D://abc.txt";// change accordingly
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);

        // 5) create Multipart object and add MimeBodyPart objects to this object
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        // 6) set the multiplart object to the message object
        message.setContent(multipart);

        // 7) send message
        Transport.send(message);

        System.out.println("message sent....");
    }
    catch (MessagingException ex) {
        System.out.println(ex);

    }

}