MimeMessage mimeMessage = new MimeMessage(session);

        MimeMultipart mimeMultipart = new MimeMultipart();


        MimeBodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setContent(message, "text/plain; charset=UTF-8");

        mimeMultipart.addBodyPart(messageBodyPart);



        MimeBodyPart attachmentBodyPart = new MimeBodyPart();

        String filename = "path to your file, exemple : /storage/path.txt" ;
        DataSource source = new FileDataSource(filename);
        attachmentBodyPart.setDataHandler(new DataHandler(source));
        attachmentBodyPart.setFileName(filename);

        mimeMultipart.addBodyPart(attachmentBodyPart);


        mimeMessage.setFrom(new InternetAddress(Config.MAIL_SENDER));

        mimeMessage.addRecipient(Message.RecipientType.TO, new 
        InternetAddress(Config.MAIL_RECEIVER));

        mimeMessage.setSubject(subject);

        mimeMessage.setContent(mimeMultipart);

        Transport.send(mimeMessage);