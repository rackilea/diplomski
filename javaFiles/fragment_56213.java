for (int i = 0; i < inventory.size(); i++){
    if (inventory.get(i) != null )
    {
        if (inventory.get(i).getHorsepower() != 0.0 ){
        if ((inventory.get(i).getHorsepower() >= lowHP) &&
                 inventory.get(i).getHorsepower() <= highHP){
                lambosHP[counter] = inventory.get(i);
            counter++
            }
        }
    }
   // counter ++;
}