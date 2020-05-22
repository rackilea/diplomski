@XmlRootElement
public class Div {

    List<Object> items = new ArrayList<Object>();

    @XmlElementRef(name="span", type=Span.class)
    @XmlMixed
    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

}