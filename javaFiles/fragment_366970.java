public class InventoryItem {

    ...
    private List<InventoryItem> composingItems = new ArrayList<>(); //if still using Java 6 this must be new ArrayList<InventoryItem>();

    ...

    public void addComposingItem(InventoryItem composingItem) {
        composingItems.add(composingItems);
    }

    public List<InventoryItem> getComposingItems() {
        //Enforce immutability so no one can mess with the collection. However
        //this doesn't guarantee immutability for the objects inside the list;
        //you will have to enforce that yourself.
        return Collections.umodifiableList(composingItems);
    }
}