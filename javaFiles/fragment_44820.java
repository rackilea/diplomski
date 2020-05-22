@EventHandler
public void onItemConsume (PlayerItemConsumeEvent e) {
    ItemStack consumed = e.getItem();
    //Make your checks if this is the Potion you want to cancel

    if (/*conditions*/) e.setCancelled(true);    //Will cancel the potion drink, not applying the effects nor using the item.
}