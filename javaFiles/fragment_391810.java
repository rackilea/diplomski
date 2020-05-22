MimeBodyPart textPart = new MimeBodyPart();
textPart.setText(text, "utf-8");

MimeBodyPart htmlPart = new MimeBodyPart();
htmlPart.setContent(html, "text/html; charset=utf-8");

multiPart.addBodyPart(textPart); // <-- first
multiPart.addBodyPart(htmlPart); // <-- second
message.setContent(multiPart);