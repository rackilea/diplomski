private boolean hasDuplicates(Recipe recipe) {
    return this.snack.equals(recipe) ||
        Stream.of(this.breakfast, this.lunch, this.dinner)
            .anyMatch(meal -> meal.getRecipe().equals(recipe)
                           || meal.getSnack().equals(recipe));
}