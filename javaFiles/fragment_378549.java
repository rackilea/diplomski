private static String getTextFromMessage(Message message) throws IOException, MessagingException {
        String result = "";
       if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        else{
             StringWriter writer = new StringWriter();
             IOUtils.copy(message.getInputStream(), writer, "UTF-8");
             result = writer.toString();
        }
        return result;
    }