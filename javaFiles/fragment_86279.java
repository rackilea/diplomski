private Ingredient createIngredient(String ingr_name, double ingr_price){
    for(Ingredient i : ingredients){
        if(i.getName().equals(ingr_name)){
            return null;
        }
    }
    Ingredient newing = new Ingredient(ingr_name, ingr_price);
    ingredients.add(newing);
    return newing;
}