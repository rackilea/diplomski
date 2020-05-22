@EventHandler //MAKE SURE YOU HAVE THIS
public void InventoryClick(InventoryClickEvent e){
    Player p = (Player) e.getWhoClicked();  

    if(e.getInventory().getTitle().contains("put the name of the GUI here (CAsE SEnsITivE)")){
        //Cancel the event so they can't take items out of the GUI
        e.setCancelled(true);

        if(e.getCurrentItem() == null){
            return;
        }
        //gets called when the current item's type (The item the player clicked) is a diamond
        else if(e.getCurrentItem().getType() == Material.DIAMOND){
            //send the player a message when they click it
            p.sendMessage("You clicked the diamond!");

            //call this if you want to close the inventory when they click it
            p.closeInventory();
        }
    }
}