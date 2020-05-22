MimeMessage message = new MimeMessage(session);
message.addRecipient(Message.RecipientType.TO, new InternetAddress("to@gmail.com"));
message.setFrom("from@gmail.com"); // <-- add 'from' email address
message.setSubject("sub");
message.setText("msg");    
Transport.send(message);