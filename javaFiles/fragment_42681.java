MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, CharEncoding.UTF_8);
message.setTo(to);
message.setFrom(from);
message.setSubject(subject);
message.setText(content, isHtml);

Properties mailProperties = new Properties();
mailProperties.put(MAIL_TRANSPORT_PROTOCOL, "smtp");
mailProperties.put(MAIL_SMTP_AUTH, "true");

javaMailSender.setJavaMailProperties(mailProperties);
javaMailSender.send(mimeMessage);