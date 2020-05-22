@XmlAccessorType(XmlAccessType.FIELD)
public class Pair {

    @XmlAttribute
    private String key;

    @XmlValue
    private String value;

    public Pair() {
    }

    public Pair(String key, String value) {
        this.key = key;
        this.value = value;
    }  
//... getters, setters  
}