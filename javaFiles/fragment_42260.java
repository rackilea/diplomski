@Override
public Recipe get(Long id) {
    Recipe recipe = recipeRepository.findOne(id);
    if(recipe == null) {
        throw new EntityNotFoundException("Recipe with id: " + id + " was not found.");
    }
    recipe.getIngredients();
    return recipe;
}