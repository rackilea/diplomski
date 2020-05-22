@EventHandler
public void onPlayerDropItem(PlayerDropItemEvent e) {
    if(event.getItemDrop().getItemStack().getType() == Material.MUSHROOM_SOUP)) 
       /* Your code here */
    {
        e.setCancelled(true);
    } else {
        e.getItemDrop().remove();
    }
}