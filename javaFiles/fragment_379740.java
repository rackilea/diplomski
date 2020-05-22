Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
         message.setSubject("Testing Subject");
         BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setText("This is message body");
         Multipart multipart = new MimeMultipart();
         multipart.addBodyPart(messageBodyPart);
         messageBodyPart = new MimeBodyPart();
         String filename = "/Mydocuments/kali/file.txt";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);
         message.setContent(multipart);
         Transport.send(message);

         System.out.println("Sent message successfully....");