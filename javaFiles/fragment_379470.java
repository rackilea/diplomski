private boolean hasDuplicates(Recipe recipe) {
    return Stream.concat(
        Stream.of(this.breakfast, this.lunch, this.dinner)
            .flatMap(meal -> Stream.of(meal.getRecipe(), meal.getSnack())),
        Stream.of(this.snack))
   .anyMatch(Predicate.isEqual(recipe));
}