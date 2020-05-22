public void action(Player p){
    PlayerInventory i = p.getInventory();
    for(int slot = 0; slot < 36 /*Size of inventory */; slot++){
        ItemStack item = i.getItem(slot);
        if (item == null || item.getType() == Material.AIR) { //Do nothing.
            continue;
        }
        Map<String, Object> itemS = item.serialize();
        if(Main.invs.get(p.getName() + ".inventory.slot." + slot) == null){
            Main.invs.createSection(p.getName()+ ".inventory.slot." + slot);
        }
        Main.invs.set(p.getName() + ".inventory.slot." + slot, itemS);
    }
}