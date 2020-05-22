public Item getItemByName(String name) { 
    for (Item item : items) {
        if (item.getName().equals(name)) {
            if (item instanceof HeadArmor) {
                return item;
            }
        }
    }
    return null;
}