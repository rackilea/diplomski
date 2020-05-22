public class Company implements Serializable {

    private String address;

    //Setter
    public void setAddress(String address) {
        this.address = address;
    }

    //Getter
    public String getAddress() { return this.address; }
}

public class UFForm implements Serializable {

    private Company company;

    public void setCompany(Company company) {
        this.company = company;
    }

    public void getCompany() {
        if (this.company == null) {
            setCompany(new Company());
        }

        return this.company;
    }
}