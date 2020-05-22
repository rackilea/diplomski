private static final long serialVersionUID = -673347532267697932L;
private ProductRecipeMapping id;
private int quntity;

public ProductRecipeMapping getId() {
    return id;
}
public void setId(ProductRecipeMapping id) {
    this.id = id;
}
public int getQuntity() {
    return quntity;
}
public void setQuntity(int quntity) {
    this.quntity = quntity;
}
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    ProductRecipe other = (ProductRecipe) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}
@Override
public String toString() {
    return "ProductRecipe [quntity=" + quntity + "]";
}
public void setProductRecipe(Set<ProductRecipe> productRecipe) {
    this.productRecipe = productRecipe;
}
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + recipeId;
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
    Recipe other = (Recipe) obj;
    if (recipeId != other.recipeId)
        return false;
    return true;
}
@Override
public String toString() {
    return "Recipe [recipeId=" + recipeId + ", name=" + name
            + ", productRecipe=" + productRecipe + "]";
}