public class BusinessError {

    private Date timestamp
    private String reason;

    public BusinessError(String Reason, Date timestamp) {
        this.timestamp = timestamp;
        this.reason = reason;
    }

    // getters and setters..
}