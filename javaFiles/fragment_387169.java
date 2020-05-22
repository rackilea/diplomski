private String status;
private String msg;

//private TransactionDetails transaction_details = new TransactionDetails();

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

HashMap<String, HashMap<String,String>> transaction_details = new HashMap<String, HashMap<String,String>>(); 

@JsonProperty("transaction_details")
public HashMap<String, HashMap<String,String>> getMap() {
    return transaction_details;
}

public void setMap(HashMap<String, HashMap<String,String>> transaction_details) {
    this.transaction_details = transaction_details;
}