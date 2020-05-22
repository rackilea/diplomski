import com.fasterxml.jackson.annotation.JsonProperty;

public class Jackson {

    private String status;
    private String msg;

    private TransactionDetails transaction_details = new TransactionDetails();

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public TransactionDetails getTransaction_details() {
        return transaction_details;
    }
    public void setTransaction_details(TransactionDetails transaction_details) {
        this.transaction_details = transaction_details;
    }

}

class TransactionDetails{

    private A3690 a3690;

    @JsonProperty("3690")
    public A3690 getA3690() {
        return a3690;
    }

    public void setA3690(A3690 a3690) {
        this.a3690 = a3690;
    }

}

class A3690{

    private String mihpayid ;
    private String status;

    public String getMihpayid() {
        return mihpayid;
    }
    public void setMihpayid(String mihpayid) {
        this.mihpayid = mihpayid;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


}