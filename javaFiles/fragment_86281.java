public Ingredient findIngredient(String name){
    for(Ingredient i : ingredients){
        if(i.getName().equals(name)){
            return i;
        }
    }
    return null;
}