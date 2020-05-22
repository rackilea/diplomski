Message message = new MimeMessage(session);
Multipart multiPart = new MimeMultipart("alternative");

MimeBodyPart textPart = new MimeBodyPart();
textPart.setText(text, "utf-8");

MimeBodyPart htmlPart = new MimeBodyPart();
htmlPart.setContent(html, "text/html; charset=utf-8");

multiPart.addBodyPart(textPart); 
multiPart.addBodyPart(htmlPart);
message.setContent(multiPart);

ByteArrayOutputStream output = new ByteArrayOutputStream();
message.writeTo(output);
String rawEmail = Base64.encodeBase64URLSafeString(output.toByteArray());

Message message = new Message();
message.setRaw(rawEmail);
message = service.users().messages().send(userId, message).execute();