public Inventory inv;

public void openGUI(Player p){
    //format: null, size of inventory (must be divisible by 9), "GUI name"
    inv = Bukkit.createInventory(null, 9, "GUI Name");
    inv.setItem(0, new ItemStack(Material.DIAMOND);
    p.openInventory(inv);
}