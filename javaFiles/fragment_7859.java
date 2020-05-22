@EventHandler
public void onEndermanBlockTake(EntityChangeBlockEvent e) {
    Entity entity = e.getEntity();
    if (entity.getType().equals(EntityType.Enderman)) {
        //It's an enderman
        Block b = e.getBlock();    //Getting the block
        e.setCancelled(true);    //Cancelling the event
    }
}