Runnable closeTask = null;
public void SetState(boolean bState) {
    if(this.bState == false && bState == true ) {
        if(closeTask != null) {
            closeTask.run();
            closeTask = null;
        }
    }
    this.bState = bState;
}

@EventHandler
public void onPlayerInteract(PlayerInteractEvent event) throws InterruptedException {
    Player player = event.getPlayer();
    if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getClickedBlock().getType() == Material.CHEST && event.getItem().getType() == Material.DIAMOND_SWORD)  {
        ...
        player.openInventory(sinv);
        closeTask = () => {
            //Some other things to do
             getLogger().info('Inventory closed');
        };

    }
}