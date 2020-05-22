public interface PlatformProvider {

    void sendSMS(String number, String message);

    List<SMSMessage> readSMSs();

    void listenToIncomingSMS();

    ObjectProperty<SMSMessage> messageProperty();

}