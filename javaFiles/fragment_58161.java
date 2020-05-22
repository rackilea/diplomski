public String foodstats (){
    StringBuilder foodstats = new StringBuilder();
    for ( int i = 0; i < consumables.size(); i++){
         foodstats.append("Name: " + consumables.get(i).getName() + "\tNutrition: " + consumables.get(i).getNValue() + "\tStamina: " + consumables.get(i).getStamina() + "\n");
   }
    return foodstats.toString();
}