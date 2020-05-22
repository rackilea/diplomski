static public Food createMeal(Food f) throws Exception {
    if(f instanceof Bread || f instanceof Meat || f instanceof Milk) {
        return f;
    }
    throw new Exception("NotAFood!");
}