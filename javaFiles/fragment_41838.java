// First, copy them across
for (int i = 0; i < inMoveOut.getItemCount(); i++) {
    if (inMoveOut.isItemSelected(i)) {
        // add item from the first listbox to the second lsitbox
        inMoveIn.addItem(inMoveOut.getItemText(i), inMoveOut.getValue(i));
    }
}

// Then delete them
for (int i = 0; i < inMoveOut.getItemCount(); i++) {
    if (inMoveOut.isItemSelected(i)) {
        // delete item from the first listbox
        inMoveOut.removeItem(i);
    }
}