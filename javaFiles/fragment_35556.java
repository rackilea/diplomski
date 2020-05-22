Multipart multipart = new MimeMultipart(); // creating a multipart is OK

// Creating the first body part of the multipart, it's OK
messageBodyPart = new MimeBodyPart();
// ... bla bla
// ok, so this body part is the "attachment file"
messageBodyPart.setDataHandler(new DataHandler(source));
// ... bla bla
multipart.addBodyPart(messageBodyPart); // at this point, the multipart contains your file attachment, but only that!

// at this point, you set your mail's body to be the HTML message    
message.setContent(html, "text/html; charset=utf-8");
// and then right after that, you **reset** your mail's content to be your multipart, which does not contain the HTML
message.setContent(multipart);