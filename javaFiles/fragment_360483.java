public class ResponseData {
private String status;

private Map<String, MasterList> masterlist;

public Map<String, MasterList> getMasterlist() {
    return masterlist;
}

public void setMasterlist(Map<String, MasterList> masterlist) {
    this.masterlist = masterlist;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public static class MasterList {
    private String session_id;

    private String session_name;

    private String bill_id;

    private String number;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
}