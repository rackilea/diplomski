int batchSize = 16; // for example, adjust it to you needs
MimeMessage[] messages = new MimeMessage[batchSize];
int messageIndex = 0;

public void sendMail(String msgFrom, String body) {
    // prepare MimeMessage
    messages[messageIndex++] = email;
    if (messagesIndex == batchSize) {
        mailSender.send(messages);
        messageIndex = 0;
    }

public void sendLastMails() {
    if (messageIndex > 0) {
        MimeMessage[] lastMessages = new MimeMessage[messageIndex];
        for (int i =0; i<messageIndex; i++) {
            lastMessages[i] = messages[i];
    }
    mailSender.send(lastMessages);
}