public class MessagePojo {
    private final Member sender;
    private final Member recipient;

    @JsonCreator
    public MessagePojo(@JsonProperty("sender") Member sender,
                       @JsonProperty("recipient") Member recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    @JsonProperty("senderId")
    public Long getSenderId() {
        return sender.getId();
    }

    @JsonProperty("recipientId")
    public Long getRecipientId() {
        return recipient.getId();
    }

    @JsonProperty("senderFirstName")
    public String getSenderFirstName() {
        return sender.getFirstName();
    }

    @JsonProperty("recipientFirstName")
    public String getRecipientFirstName() {
        return recipient.getFirstName();
    }
}