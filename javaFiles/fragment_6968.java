private List<String> selectedItems; // + getter + setter
private List<SelectItem> selectItems; // + getter only

public Bean() {
    // Fill select items during Bean initialization/construction.
    selectItems = new ArrayList<SelectItem>();
    selectItems.add(new SelectItem("value1", "label1"));
    selectItems.add(new SelectItem("value2", "label2"));
    selectItems.add(new SelectItem("value3", "label3"));
}

public void submit() {
    // JSF has already put selected items in `selectedItems`.
    for (String selectedItem : selectedItems) {
        System.out.println("Selected item: " + selectedItem); // Prints value1, value2 and/or value3, depending on selection.
    }
}