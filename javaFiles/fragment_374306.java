class Client {
    private int clientIdentifier;
    private String clientName;
    private String clientFamilyname;
    private String clientBirthdate;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientFamilyname() {
        return clientFamilyname;
    }

    public void setClientFamilyname(String clientFamilyname) {
        this.clientFamilyname = clientFamilyname;
    }

    public String getClientBirthdate() {
        return clientBirthdate;
    }

    public void setClientBirthdate(String clientBirthdate) {
        this.clientBirthdate = clientBirthdate;
    }

    public int getClientIdentifier() {
        return clientIdentifier;
    }

    public Client(int clientIdentifier, String clientName, String clientFamilyname, String clientBirthdate) {
        this.clientIdentifier = clientIdentifier;
        this.clientName = clientName;
        this.clientFamilyname = clientFamilyname;
        this.clientBirthdate = clientBirthdate;
    }
}