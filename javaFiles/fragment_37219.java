@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Doc {
    @XmlElementWrapper(name = "items")
    @XmlElement(name="item")
    List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        this.items.add(item);
    }

    // ...
}