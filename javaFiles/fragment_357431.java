@Data
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)      // UPDATE: Need this or else exception
public class Data {
    @XmlElement(name = "test")
    public double testData;
}