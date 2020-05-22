public PlayerInventory deserializeInventory(Player p) {
    PlayerInventory inv = p.getInventory();
    for(int slot = 0; slot < 36 /*Size of inventory */; slot++){
        //Removes any existing item from the inventory.
        inv.clear(slot);

        Object itemTemp = Main.invs.get(p.getName() + ".inventory.slot." + slot);
        if (itemTemp == null) { //Skip null values.
            continue;
        }
        if (!(itemTemp instanceof ItemStack)) {
            //Might want to do an error message, but for now just ignore this.
            continue;
        }
        ItemStack item = (ItemStack) itemTemp;
        inv.setItem(slot, item);
    }
    return inv;
}