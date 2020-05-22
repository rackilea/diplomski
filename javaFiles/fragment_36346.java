// going dirty: replace super's selectedItem/Index property 
// with guarded cousins 
itemReplacement = new ReadOnlyObjectWrapper<>(this, "selectedItem");
replaceField("selectedItem", itemReplacement);
indexReplacement = new ReadOnlyIntegerWrapper(this, "selectedIndex", -1);
replaceField("selectedIndex", indexReplacement);

// usage in methods that update single selection state
protected void syncSingleSelectionState(int selectedIndex) {
    Guard guard = Guard.multi(itemReplacement.guard(), indexReplacement.guard());
    setSelectedIndex(selectedIndex);
    if (selectedIndex > -1) {
        setSelectedItem(getModelItem(selectedIndex));
    } else {
        // PENDING JW: do better? can be uncontained item
        setSelectedItem(null);
    } 
    guard.close();
    focus(selectedIndex);
}