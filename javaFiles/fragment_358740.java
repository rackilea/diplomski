final String username = "myemail@gmail.com";
        final String password = "Password";    

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });    


        InetAddress i = InetAddress.getByName(ipAddress);
        System.out.println("Sending Ping Request to " + ipAddress);
        if (i.isReachable(5000)) //5 second limit
            System.out.println("Host is online \n");
        else {
            System.out.println("HOST IS OFFLINE\n");

        try {


            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("myemail@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("receiveremail@hotmail.com"));
            message.setSubject("Project Test Mail");
            message.setText("Test Mail,"
                + "\n\n Sent From sendMail.java application");

            Transport.send(message);

            System.out.println("Mail Sent to receiveremail@hotmail.com " 
             +     ipAddress);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    } 
}