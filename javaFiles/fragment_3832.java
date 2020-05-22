super.updateItem(item, empty);
if (item != null) {
   setText(item.getPlate());
} else {
   setText("");   // <== clear the now empty cell.
}