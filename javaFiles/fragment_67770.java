public class AndroidPlatformProvider implements PlatformProvider {

    private final SmsListener receiver = new SmsListener();

    @Override
    public void listenToIncomingSMS() {
        FXActivity.getInstance().registerReceiver(receiver, new IntentFilter(Intents.SMS_RECEIVED_ACTION));
    }

    @Override
    public ObjectProperty<SMSMessage> messagesProperty() {
        return receiver.messagesProperty();
    }

}