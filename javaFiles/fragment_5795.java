@XmlRootElement
public class Span {

    List<Object> items = new ArrayList<Object>();

    @XmlMixed
    @XmlElementRef(type=Div.class, name="div")
    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> mixed) {
        this.items = items;
    }


}