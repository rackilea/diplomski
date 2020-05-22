class MyMessage extends MimeMessage {
    ...

    protected void updateMessageID() throws MessagingException {
  setHeader("Message-ID", "my-message-id");
    }
    ...
}