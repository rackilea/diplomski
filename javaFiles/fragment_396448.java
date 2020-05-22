@WebMethod
public Integer transferPalletRecords2(PalletRecord2Array palRec) {
    try {
        System.out("Got " + palRec.getItems().size() + " items!");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}

// PalletRecord XML Struktur
@XmlRootElement(name = "arg0")
@XmlAccessorType(XmlAccessType.FIELD)
public static class PalletRecord2Array {

    @XmlElement(name = "item", required = true)
    protected List<Item> items;

    public List<Item> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

}

public static class Item {
...
}