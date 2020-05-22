double sum = 0;
for (int index = 0; index < model.size(); index++) {
    Item item = (Item)model.getElementAt(index);
    sum += item.getPrice();
}
// Display sum somewhere on the screen...