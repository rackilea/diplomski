public static <T> T getSelectedRow(Table table, ToLongFunction<T> idGetter) {
    T selectedItems = (T) table.getValue();
    if (selectedItems != null) {
        System.out.println("getSelectedRow id:"+ idGettter.apply(selectedItems));
        return selectedItems;
    }
...

Inventory inventory = getSelectedRow(table, Inventory::getId);