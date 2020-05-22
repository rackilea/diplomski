@EventHandler
public void onCreeperExplode(EntityExplodeEvent e) {
    Entity entity = e.getEntity();
    if (entity.getType().equals(EntityType.CREEPER)) {
    //It's a creeper
    //You can cancel it
    e.setCancelled(true);    //This prevents damage

    //Or cancel the block destruction
    e.blockList().clear();
    }
}