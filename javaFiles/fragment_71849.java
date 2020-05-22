public String toppings() {
    StringBuilder builder = new StringBuilder();
    for (Ingredient ingredient : ingredients){
        if (ingredient.hasType(Kitchen.TOPPING)) {
            if (builder.length() > 0) {
                builder.append(", ");
            }
            builder.append(ingredient.ingtoString());
        }
    }
    return builder.toString();
}