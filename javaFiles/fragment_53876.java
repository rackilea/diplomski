@Override
protected void updateItem(ItemType item, boolean empty) {
    super.updateItem(item, empty);
    if (empty) {
        // undo any updates that could have been made
        // to make the cell look different from the empty cell
    } else {
        // update cell to display item
    }
}