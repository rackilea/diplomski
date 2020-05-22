@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient implements Serializable
{
    @EmbeddedId
    private RecipeIngredientId id;

    @MapsId("ingredientId") // maps ingredientId attribute of embedded id
    @ManyToOne
    @JoinColumn(name="ingredient_id", insertable = false, updatable = false)
    private Ingredient ingredient;

    @MapsId("recipeId") // maps recipeId attribute of embedded id
    @ManyToOne
    @JoinColumn(name = "recipe_id", insertable = false, updatable = false)
    private Recipe recipe;
    private double amount;

    public RecipeIngredient() {}

    public RecipeIngredient(Recipe recipe, Ingredient ingredient, double amount){
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.amount = amount;
    }
}