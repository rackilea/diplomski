@XmlRootElement(name="P1)
public class P1 {

    List<CTS> cts;

    @XmlElement(name = "CTS")
    public List<CTS> getCts() {
        return cts;
    }

}