public class MessageListenerContainer extends DefaultMessageListenerContainer {

@Override protected void refreshConnectionUntilSuccessful() {
    super.refreshConnectionUntilSuccessful();
    // Your own implementation goes here like sending an email
    logger.error(MessageListenerContainer.class, new Exception("MQ CONNECTION LOST"));
}}