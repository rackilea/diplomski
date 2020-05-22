class RecordContainer {
    ArrayList<Record> Records;
}

class Record {
    public String EventSource;
    public String EventVersion;
    public String EventSubscriptionArn;
    public Sns Sns;     
}

class Sns {
    public String Type;
    public String MessageId;
    public String TopicArn;
    public String Subject;
    public String Message;
    public String Timestamp;
    public String SignatureVersion;
    public String Signature;
    public String SigningCertUrl;
    public String UnsubscribeUrl;
    public MessageAttributes MessageAttributes;
}