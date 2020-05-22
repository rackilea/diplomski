JSONArray rootArray = new JSONArray(result);
    // For each Recipe
    for (int i = 0; i < rootArray.length(); i++) {
        JSONObject tempObject = rootArray.getJSONObject(i);
        JSONArray jIngredients = tempObject.getJSONArray("ingredients");
        JSONArray jSteps = tempObject.getJSONArray("steps");

        // Get the ingredients
        List<Ingredients> ingredients = new ArrayList<>();
        for(int j = 0 ; j< jIngredients.length(); j++) {
            JSONObject tempIngredient = jIngredients.getJSONObject(j);
            Ingredients newIngredient = new Ingredients(tempIngredient.getString("quantity"),
                    tempIngredient.getString("measure"),
                    tempIngredient.getString("ingredient"));
            ingredients.add(newIngredient);
        }

        // Get the steps
        List<Steps> steps = new ArrayList<>();
        for (int j = 0; j < jSteps.length(); j++) {
            JSONObject tempStep = jSteps.getJSONObject(j);
            Steps newStep = new Steps(tempStep.getString("id"), tempStep.getString("shortDescription"),
                    tempStep.getString("description"), tempStep.getString("videoURL"));
            steps.add(newStep);
        }

        // Create the recipe
        Recipe newRecipe = new Recipe(tempObject.getString("id"), tempObject.getString("name"), tempObject.getString("servings"), ingredients, steps);
        MainActivity.mRecipies.add(newRecipe);
    }