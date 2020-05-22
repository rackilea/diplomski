private boolean hasDuplicates(Recipe recipe) {
    return this.snack.equals(recipe) ||
        Stream.of(this.breakfast, this.lunch, this.dinner)
            .flatMap(meal -> Stream.of(meal.getRecipe(), meal.getSnack())
            .anyMatch(Predicate.isEqual(recipe));
}