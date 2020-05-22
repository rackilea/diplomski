@XmlRootElement(name = "WEB-ITM-EXT-REC")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemDocuments {

    @XmlElement(name = "WEB-ITM-EXT-DATA")
    public List<ItemDocument> itemDocumentList = new ArrayList<ItemDocument>();

    public List<ItemDocument> getItemDocumentList() {
        return itemDocumentList;
    }

    public void setItemDocumentList(List<ItemDocument> itemDocumentList) {
        this.itemDocumentList = itemDocumentList;
    }
}