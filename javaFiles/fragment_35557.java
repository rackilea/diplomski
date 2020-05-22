Multipart multipart = new MimeMultipart(); //1
// Create the attachment part
BodyPart attachmentBodyPart = new MimeBodyPart(); //2
attachmentBodyPart.setDataHandler(new DataHandler(fileDataSource)); //2
attachmentBodyPart.setFileName(file.getName()); // 2
multipart.addBodyPart(attachmentBodyPart); //3
// Create the HTML Part
BodyPart htmlBodyPart = new MimeBodyPart(); //4
htmlBodyPart.setContent(htmlMessageAsString , "text/html"); //5
multipart.addBodyPart(htmlBodyPart); // 6
// Set the Multipart's to be the email's content
message.setContent(multipart); //7