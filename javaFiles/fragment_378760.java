Set<Account> recipeLovers = recipe.getRecipeLovers();
recipeLovers.forEach(account ->
    account.getFavouriteRecipes()
        .removeIf(r -> r.getId() == recipeId));
recipeLovers.clear();
recipeDao.delete(recipe);