MultiPartEmail email = new MultiPartEmail();
email.setHostName(smtpServer);
email.addTo(to);
email.setFrom(from);
email.setSubject(subject);
email.setMsg(msg);
email.setSocketTimeout(20000);
email.setSocketConnectionTimeout(20000);
// SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
// soapMessage.createAttachmentPart(); // enough for empty body
new AttachmentPartImpl(); // enough for empty body
// new MimeHeaders(); not enough for empty body
email.send();