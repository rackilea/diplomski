MimeMultipart multipart = new MimeMultipart();

String htmlContent = "<p>Hello World!</p>"
// add HTML content here
final MimeBodyPart  messageBodyPart = new MimeBodyPart();
// HTML Content
messageBodyPart.setContent(htmlContent, "text/html;charset=UTF-8");

// add it
multipart.addBodyPart(messageBodyPart);

// don't forget to add the content to your message.
message.setContent(multipart);