@XmlRootElement(name="MESSAGE")
public class Message {

    private String messageId;
    private String qrCode;
    private String respCode;
    private String respDesc;

    @XmlElement(name="MESSAGE_ID")
    public String getMessageId() {
        return messageId;
    }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    @XmlElement(name="QR_CODE")
    public String getQrCode() {
        return qrCode;
    }
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
    @XmlElement(name="RESP_CODE")
    public String getRespCode() {
        return respCode;
    }
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
    @XmlElement(name="RESP_DESC")
    public String getRespDesc() {
        return respDesc;
    }
    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }
}