@XmlAccessorType(XmlAccessType.FIELD)
public class Subscription {

    @XmlElement(name = "INFO")
    @XmlJavaTypeAdapter(MyMapAdapter.class)
    private Map<String, String> infoMap;
}