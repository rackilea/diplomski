@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemDocument {

    @XmlElement(name = "ITEM-NO")
    private String itemNo;

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

}