private static final long serialVersionUID = -4466109438914540231L;
private Product product;
private Recipe recipe;
public Product getProduct() {
    return product;
}
public void setProduct(Product product) {
    this.product = product;
}
public Recipe getRecipe() {
    return recipe;
}
public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
}
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((product == null) ? 0 : product.hashCode());
    result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
    return result;
}
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    ProductRecipeMapping other = (ProductRecipeMapping) obj;
    if (product == null) {
        if (other.product != null)
            return false;
    } else if (!product.equals(other.product))
        return false;
    if (recipe == null) {
        if (other.recipe != null)
            return false;
    } else if (!recipe.equals(other.recipe))
        return false;
    return true;
}