public void addItem(Item item) {
    items.add(item);
    item.setCart(this);
}

public void removeItem(Item item) {
    items.remove(item);
    item.setCart(null);
}