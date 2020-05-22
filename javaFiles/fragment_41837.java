int size = inMoveOut.getItemCount()
for (int i = size - 1; i >= 0 ; i--) {
    if (inMoveOut.isItemSelected(i)) {
        // add item from the first listbox to the second lsitbox
        inMoveIn.addItem(inMoveOut.getItemText(i), inMoveOut.getValue(i));
        // delete item from the first listbox
        inMoveOut.removeItem(i);
    }
}