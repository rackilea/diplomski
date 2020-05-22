public class Message {
    public Member sender;
    public Member recipient;

    public Message(Member sender, Member recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    public Long getSenderId() {
        return sender.getId();
    }

    public Long getRecipientId() {
        return recipient.getId();
    }

    public String getSenderFirstName() {
        return sender.getFirstName();
    }

    public String getRecipientFirstName() {
        return recipient.getFirstName();
    }
}