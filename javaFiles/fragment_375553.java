public void showInventory(List<Item> items) {
    for (Item item : items) {
        if (item instanceof ContainerItem) {
            // container display logic here
        }
        else if (item instanceof WeaponItem) {
            // weapon display logic here
        }
        // etc etc
    }
}