public void initialize() {
    // TODO Auto-generated method stub
    for (int i = 0; i < ItemManager.inventoryItems.size(); i++) {
        options.add(ItemManager.inventoryItems.get(i).getName());
    }
    stocks.setItems(options);
}