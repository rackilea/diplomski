@EventHandler
public void onItemConsume (PlayerItemConsumeEvent e) {
    ItemStack consumed = e.getItem();
    if (consumed.getType.equals(Material.POTION) {
        //It's a potion
        Potion potion = Potion.fromItemStack(consumed);
        PotionType type = potion.getType();
        if (type.equals(PotionType.INSTANT_HEAL) e.setCancelled(true);
    }
}