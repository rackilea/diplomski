@XmlRootElement(name="home", namespace = "http://www.example.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer  {

    @XmlElement(name="home_003", namespace = "http://www.example.com")
    protected Date dateDebut;

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

}