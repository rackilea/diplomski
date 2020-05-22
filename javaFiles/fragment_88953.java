public class Billing {
    private Lisense license;

    public Billing(License license){
        this.license = license;
    }

    public void pay(){
       // some code
       this.license.calcFee();
       // some code
    }

    public void setLicense(License license){
        this.license = license;
    }
}