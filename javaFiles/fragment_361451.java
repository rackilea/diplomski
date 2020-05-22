public class ItemDetailsWrapper implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<ItemDetails> itemDetails;

    public ItemDetailsWrapper(ArrayList<ItemDetails> items) {
        this.itemDetails = items;
    }

    public ArrayList<ItemDetails> getItemDetails() {
        return itemDetails;
    }
}

public class ItemDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    // getters, setters and properties
}