public void addPotion(int numOfPotions, Player player){
    for(int i = 0; i < numOfPotions; i ++){
        player.getInventory().add(potion());
    }
}

public Item potion(){
    return new Item ("Potion", "Potion", " a small vial filled with a "
            + "translucent red liquid");
}