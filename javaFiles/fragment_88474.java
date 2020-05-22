public abstract class MessageMixin {
    @JsonIgnore
    Member sender;

    @JsonIgnore
    Member recipient;

    @JsonProperty("senderId")
    abstract Long getSenderId();

    @JsonProperty("recipientId")
    abstract Long getRecipientId();

    @JsonProperty("senderFirstName")
    abstract String getSenderFirstName();

    @JsonProperty("recipientFirstName")
    abstract String getRecipientFirstName();
}