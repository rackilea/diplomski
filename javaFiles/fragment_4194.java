String to="somebody@something.com";//change accordingly  
    final String user="me@gmail.com"; //change accordingly  
    final String password="xxxxx";//change accordingly  

    //1) get the session object     
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com"); // for gmail use smtp.gmail.com
    props.put("mail.smtp.auth", "true");
    props.put("mail.debug", "true"); 
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.port", "465");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");

    Session session = Session.getDefaultInstance(props,  
            new javax.mail.Authenticator() {  
        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {  
            return new javax.mail.PasswordAuthentication(user,password);  
        }  
    });  

    //2) compose message     
    try{  
        MimeMessage message = new MimeMessage(session);  
        message.setFrom(new InternetAddress(user));  
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
        message.setSubject("Message Alert");  

        //3) create MimeBodyPart object and set your message text     
        BodyPart messageBodyPart1 = new MimeBodyPart();  
        messageBodyPart1.setText("This is message body");  

        //4) create new MimeBodyPart object and set DataHandler object to this object      
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();  

        String filename = "SendAttachment.doc";//change accordingly  
        DataSource source = new FileDataSource(filename);  
        messageBodyPart2.setDataHandler(new DataHandler(source));  
        messageBodyPart2.setFileName(filename);  


        //5) create Multipart object and add MimeBodyPart objects to this object      
        Multipart multipart = new MimeMultipart();  
        multipart.addBodyPart(messageBodyPart1);  
        multipart.addBodyPart(messageBodyPart2);  

        //6) set the multipart object to the message object  
        message.setContent(multipart );  

        //7) send message  
        Transport.send(message);  

        System.out.println("message sent....");  
    }catch (MessagingException ex) {
        ex.printStackTrace();
    }