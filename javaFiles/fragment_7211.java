@XmlRootElement
public class Game {

    private List<String> textValue;
    private String id;
    private String name;
    private String translation;

    @XmlMixed
    public List<String> getTextValue() {
        return textValue;
    }
    public void setTextValue(List<String> textValue) {
        this.textValue = textValue;
    }
    @XmlElement
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @XmlElement
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public String getTranslation() {
        return translation;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }
}