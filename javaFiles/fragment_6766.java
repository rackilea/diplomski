String fromEmail = "admin@example.com";
String fromName = "Site Administrator";
String subject = "Hello from example.com";
String body = "text of message";
InternetAddress from = new InternetAddress(fromEmail, fromName);
InternetAddress to = InternetAddress.parse("xxx");
MailMessage emailMessage = new MailMessage(from, to, subject, body, false);
MailServiceUtil.sendEmail(emailMessage);