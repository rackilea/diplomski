public interface HasId {
    long getId();
}

public class Inventory implements HasId {

    @Override
    public long getId() { return id; }
}

public static <T extends HasId> T getSelectedRow(Table table) {
    T selectedItems = (T) table.getValue();
    if (selectedItems != null) {
        System.out.println("getSelectedRow id:"+ selectedItems.getId());
        return selectedItems;
    }
...