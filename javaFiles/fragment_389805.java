@XmlRootElement(name="return_msg")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReturnMsg{

    @XmlElement
    private String status_desc;

    @XmlElement
    private String status_code;

    @XmlMixed
    private List<String> mixedContent;

    //Getters and Setters

}