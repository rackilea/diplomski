public class Recipe implements Cloneable {

    String name;

    final int INGREDIENT_ARRAY_MAX = 10;

    Ingredient[] ingredients = new Ingredient[INGREDIENT_ARRAY_MAX];

    public Recipe(String name) {
        this.name = name;
    }

    //Copy Constructor
    private Recipe(Recipe recipe){
        this.name = recipe.name;
        for(int x = 0; x < recipe.ingredients.length; x++){
            this.ingredients[x] = recipe.ingredients[x];
        }
    }

    public static Recipe newInstance(Recipe recipe){
        return new Recipe(recipe);
    }

    //Debug Method
    public static void printRecipe(Recipe recipe){
        System.out.println("Recipe: " + recipe.name);
        for(Ingredient i:recipe.ingredients){
          if(i != null && i.getName() != null){
              System.out.println("Ingredient: " + i.getName());           
          }
        }
    }

    //Test Method
    public static void main(String[] args) {
        Recipe recipe = new Recipe("Chicken Soup");
        recipe.ingredients[0] = new Ingredient("Chicken");
        recipe.ingredients[1] = new Ingredient("Broth");

        Recipe copy = new Recipe(recipe);
        copy.ingredients[2] = new Ingredient("Rice");
        copy.name = "Chicken Rice Soup";

        printRecipe(recipe);
        printRecipe(copy);
        System.out.println(recipe == copy);
        System.out.println(recipe.ingredients == copy.ingredients);
    }
}