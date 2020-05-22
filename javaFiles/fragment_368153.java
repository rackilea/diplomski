@XmlRootElement(name = "Entity")
@XmlSeeAlso({LabelledElement.class}) //Might not be necessary
@XmlAccessorType(XmlAccessType.NONE)
public class Entity {
    @XmlElement(name = "Header")
    private Header header;

    @XmlPath("child::*[position() = 2]")
    @XmlJavaTypeAdapter(MapAdapter.class)
    private Map<String,LabelledElement> labelledElementMap;


    public LabelledElement getLabelledElement(){
         return labelledElementMap.values().get(0);
    }
    // constructors, getters, setters...
}