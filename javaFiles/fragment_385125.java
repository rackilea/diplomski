public HashMap<String, Integer> mana = new HashMap<String, Integer>();
public ArrayList<String> changedMana = new ArrayList<String>();

@Override
public void onEnable(){
  Bukkit.getServer().getScheduler().runTaskTimer(plugin, new Runnable(){
    public void run(){
      List<String> toRemove = new ArrayList<String>();

      for(String player : changedMana){ //loop through all of the players in the ArrayList
        int current = mana.get(player); //get the player's current mana
        if(current < 20){ //if the player's mana is less than 20
           current++; //add to the player's mana
           mana.put(player, current); //update the player's mana
        }
        else if(current == 20){ //if the player's mana is greater than or equal to 20
           toRemove.add(player); //add the player to the toRemove list, in order to remove the player from the ArrayList later safely
        }
        else{
           //do something if the current mana is > 20, if you don't want to, just remove this
        }
      }

      changedMana.removeAll(toRemove); //remove players from the changed mana array
    }
  },20L,20L);
}