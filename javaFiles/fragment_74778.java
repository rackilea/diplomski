Message emailMessage = new MimeMessage(mailSession);
        emailMessage.setFrom(new InternetAddress(origin1));
        emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiptnt1));
        emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiptnt2));
        emailMessage.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc1));
        emailMessage.setSubject(emailTitle);
//            emailMessage.setText(emailContent);

        Multipart multipart1 = new MimeMultipart();
        BodyPart messageBodyPart = new MimeBodyPart();
        // Fill the message
        messageBodyPart.setText(emailContent);
        // Part two is attachment
        BodyPart attachment = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        attachment.setDataHandler(new DataHandler(source));
        attachment.setFileName(filename);
        multipart1.addBodyPart(attachment);
        multipart1.addBodyPart(messageBodyPart);
        // Put parts in message
        emailMessage.setContent(multipart1);
        //System.out.println("\n\nSend email :"+eMArray[0]);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());