MimeMessageParser parser = new MimeMessageParser(message);
String from = parser.getFrom();
String htmlContent = parser.parse().getHtmlContent();
System.out.println("Body: "+htmlContent);
String plain = parser.parse().getPlainContent();
System.out.println("plain: "+plain);