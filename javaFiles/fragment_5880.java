@XmlRootElement(name="TRX_MESSAGE")
public class TRXMessage {

    private Message message;

    @XmlElement(name="MESSAGE")
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}