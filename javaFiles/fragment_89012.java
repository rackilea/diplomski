public LinkedList<Integer> getSelectedItems() {
    LinkedList<Integer> selectedItems = new LinkedList<Integer>();
    for (int i = 0; i < getItemCount(); i++) {
        if (isItemSelected(i)) {
            selectedItems.add(i);
        }
    }
    return selectedItems;
}